package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlDepartureForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VehicleControlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class VehicleControlServiceImpl implements VehicleControlService {

    final VehicleControlRepository vehicleControlRepository;
    final VehicleService vehicleService;
    final VacancyService vacancyService;

    public VehicleControlServiceImpl(VehicleControlRepository vehicleControlRepository, VehicleService vehicleService, VacancyService vacancyService) {
        this.vehicleControlRepository = vehicleControlRepository;
        this.vehicleService = vehicleService;
        this.vacancyService = vacancyService;
    }

    @Override
    public ResponseEntity<VehicleControlDto> create(VehicleControlEntryForm form) {
        verifyVehicleHasPendingEntry(form.getVehicleId());
        VehicleControl vehicleControl = form.convertToEntity(vehicleService);
        vacancyService.incrementAmountOccupied(vehicleControl);
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControlRepository.save(vehicleControl)));
    }

    @Override
    public ResponseEntity<VehicleControlDto> terminate(VehicleControlDepartureForm form) { vehicleService.verifyAndGetById(form.getVehicleId());
        VehicleControl vehicleControl = verifyVehicleHasPendingDeparture(form.getVehicleId());
        verifyDepartureIsAfterEntry(form.getDeparture(), vehicleControl.getEntry());
        vacancyService.decrementAmountOccupied(vehicleControl);
        vehicleControl.setDeparture(form.getDeparture());
        Duration duration = Duration.between(vehicleControl.getEntry(), form.getDeparture());
        vehicleControl.setDuration(duration);
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControlRepository.save(vehicleControl)));
    }

    @Override
    public ResponseEntity<VehicleControlDto> cancelById(Long id) {
        VehicleControl vehicleControl = decrementIfExistAndNotTermined(id);
        vehicleControl.setIsCancelled(true);
        vehicleControlRepository.save(vehicleControl);
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControl));
    }

    private Optional<VehicleControl> verifyVehicleHasPendingControl(Long vehicleId) {
        vehicleService.verifyAndGetById(vehicleId);
        return vehicleControlRepository.findNotTerminatedByVehicleId(vehicleId);
    }

    private void verifyVehicleHasPendingEntry(Long vehicleId) {
        if(verifyVehicleHasPendingControl(vehicleId).isPresent())
            throw new IllegalArgumentException("Esse veículo tem uma entrada pendente");
    }

    private VehicleControl verifyVehicleHasPendingDeparture(Long vehicleId) {
        Optional<VehicleControl> vehicleControl = verifyVehicleHasPendingControl(vehicleId);
        if(vehicleControl.isPresent())
            return vehicleControl.get();
        throw new IllegalArgumentException("Esse veículo nao tem nenhuma saida pendente");
    }

    private void verifyDepartureIsAfterEntry(Instant departure, Instant entry) {
        if(!departure.isAfter(entry)) {
            throw new IllegalArgumentException("O horário de saída deve maior que o horário de entrada");
        }
    }

    private VehicleControl decrementIfExistAndNotTermined(Long id) {
        VehicleControl vehicleControl = verifyAndGetById(id);
        if(vehicleControl.getDeparture() == null)
            vacancyService.decrementAmountOccupied(vehicleControl);
        return vehicleControl;
    }

    private VehicleControl verifyAndGetById(Long id) {
        Optional<VehicleControl> optional = vehicleControlRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Controle de veículos com id " + id + " não foi encontrado");
    }
}

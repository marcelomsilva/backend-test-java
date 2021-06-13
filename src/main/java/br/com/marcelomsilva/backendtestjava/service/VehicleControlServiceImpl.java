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
        VehicleControl vehicleControl = form.convertToEntity(vehicleService);
        try {
            vacancyService.incrementAmountOccupied(vehicleControl);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControlRepository.save(vehicleControl)));
    }

    @Override
    public ResponseEntity<VehicleControlDto> terminate(VehicleControlDepartureForm form) {
        Optional<VehicleControl> vehicleControl = vehicleControlRepository.findByVehicleId(form.getVehicleId());
        if(vehicleControl.isPresent()) {
            try {
                verifyDepartureIsAfterEntry(form.getDeparture(), vehicleControl.get().getEntry());
                vacancyService.decrementAmountOccupied(vehicleControl.get());
                vehicleControl.get().setDeparture(form.getDeparture());
                Duration duration = Duration.between(vehicleControl.get().getEntry(), form.getDeparture());
                vehicleControl.get().setDuration(duration);
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().body(new VehicleControlDto(vehicleControlRepository.save(vehicleControl.get())));
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<VehicleControlDto> cancelById(Long id) {
        VehicleControl vehicleControl = verifyAndGetById(id);
        vehicleControl.setIsCancelled(true);
        vehicleControlRepository.save(vehicleControl);
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControl));
    }

    private void verifyDepartureIsAfterEntry(Instant departure, Instant entry) throws Exception {
        if(!departure.isAfter(entry)) {
            throw new Exception("");
        }
    }

    private VehicleControl verifyAndGetById(Long id) {
        Optional<VehicleControl> optional = vehicleControlRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Controle de veículos com id " + id + " não foi encontrado");
    }
}

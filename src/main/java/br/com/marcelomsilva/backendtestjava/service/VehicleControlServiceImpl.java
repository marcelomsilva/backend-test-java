package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlDepartureForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VehicleControlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


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
        VehicleControl vehicleControl = vehicleControlRepository.findByVehicleId(form.getVehicleId());
        try {
            vacancyService.decrementAmountOccupied(vehicleControl);
            vehicleControl.setDeparture(form.getDeparture());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControlRepository.save(vehicleControl)));
    }
}

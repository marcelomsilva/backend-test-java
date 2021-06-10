package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.entity.Type;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VacancyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleControlServiceImpl implements VehicleControlService {

    final VehicleService vehicleService;
    final VacancyService vacancyService;
    final VacancyRepository vacancyRepository;

    public VehicleControlServiceImpl(VehicleService vehicleService, VacancyService vacancyService, VacancyRepository vacancyRepository) {
        this.vehicleService = vehicleService;
        this.vacancyService = vacancyService;
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public ResponseEntity<VehicleControlDto> create(VehicleControlEntryForm form) {
        VehicleControl vehicleControl = form.convertToEntity(vehicleService);
        Type type = vehicleControl.getVehicle().getModel().getType();
        Optional<Vacancy> vacancy = vehicleControl.getVehicle().getParking().getVacancies().stream().filter(v -> v.getType().equals(type)).findFirst();
        if(vacancy.isPresent())
            vacancy.get().incrementAmountOccupied();
        vacancyRepository.save(vacancy.get());
        return ResponseEntity.ok().body(new VehicleControlDto(vehicleControl));
    }
}

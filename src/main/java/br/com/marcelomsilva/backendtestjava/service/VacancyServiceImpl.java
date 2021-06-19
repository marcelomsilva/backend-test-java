package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.Type;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService {

    final VacancyRepository vacancyRepository;
    final ParkingService parkingService;
    final TypeService typeService;

    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository, ParkingService parkingService, TypeService typeService) {
        this.vacancyRepository = vacancyRepository;
        this.parkingService = parkingService;
        this.typeService = typeService;
    }

    @Override
    public ResponseEntity<VacancyDto> create(VacancyForm form) {
        return ResponseEntity.ok().body(new VacancyDto(vacancyRepository.save(form.convertToEntity(typeService, parkingService))));
    }

    @Override
    public void incrementAmountOccupied(VehicleControl vehicleControl) {
        Optional<Vacancy> vacancy = this.getVacancyByTypeId(vehicleControl);
        if(vacancy.isPresent()) {
            if (vacancy.get().getAmountOccupied() < vacancy.get().getAmount()) {
                vacancy.get().incrementAmountOccupied();
                vacancyRepository.save(vacancy.get());
            } else  {
                throw new IllegalArgumentException("Não há nenhuma vaga disponível");
            }
        }
    }

    @Override
    public void decrementAmountOccupied(VehicleControl vehicleControl) {
        Optional<Vacancy> vacancy = this.getVacancyByTypeId(vehicleControl);
        if(vacancy.isPresent()) {
            if (vacancy.get().getAmountOccupied() > 0) {
                vacancy.get().decrementAmountOccupied();
                vacancyRepository.save(vacancy.get());
            } else  {
                throw new IllegalArgumentException("Não há nenhuma vaga ocupada");
            }
        }
    }

    private Optional<Vacancy> getVacancyByTypeId(VehicleControl vehicleControl) {
        Type vehicleType = vehicleControl.getVehicleType();
        return vehicleControl.getParkingVacancies().stream()
                .filter(v -> v.getType().getId() == vehicleType.getId())
                .findFirst();
    }

}

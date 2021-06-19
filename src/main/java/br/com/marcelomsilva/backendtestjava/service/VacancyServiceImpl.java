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
        Vacancy vacancy = this.getVacancyByTypeId(vehicleControl);
        if (vacancy.getAmountOccupied() < vacancy.getAmount()) {
            vacancy.incrementAmountOccupied();
            vacancyRepository.save(vacancy);
        } else  {
            throw new IllegalArgumentException("Não há nenhuma vaga disponível");
        }
    }

    @Override
    public void decrementAmountOccupied(VehicleControl vehicleControl) {
        Vacancy vacancy = this.getVacancyByTypeId(vehicleControl);
        if (vacancy.getAmountOccupied() > 0) {
            vacancy.decrementAmountOccupied();
            vacancyRepository.save(vacancy);
        } else  {
            throw new IllegalArgumentException("Não há nenhuma vaga ocupada");
        }
    }

    private Vacancy getVacancyByTypeId(VehicleControl vehicleControl) {
        Optional<Vacancy> optionalVacancy = vacancyRepository.findParkingVacancyByTypeId(vehicleControl.getParking().getId(), vehicleControl.getVehicleType().getId());
        if(optionalVacancy.isPresent())
            return optionalVacancy.get();
        throw new IllegalArgumentException("Não há vagas para esse tipo de veículo");
    }

}

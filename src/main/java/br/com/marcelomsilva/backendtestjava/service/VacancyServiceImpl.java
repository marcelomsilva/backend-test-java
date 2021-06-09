package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.repository.VacancyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {

    final VacancyRepository vacancyRepository;
    final ParkingService parkingService;
    final TypeService typeService;

    public VacancyServiceImpl(VacancyRepository vacancyRepository, ParkingService parkingService, TypeService typeService) {
        this.vacancyRepository = vacancyRepository;
        this.parkingService = parkingService;
        this.typeService = typeService;
    }

    @Override
    public ResponseEntity<VacancyDto> create(VacancyForm form) {
        return ResponseEntity.ok().body(new VacancyDto(vacancyRepository.save(form.convertToEntity(typeService, parkingService))));
    }
}

package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.TypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {

    final ParkingService parkingService;
    final TypeService typeService;

    public VacancyServiceImpl(ParkingService parkingService, TypeService typeService) {
        this.parkingService = parkingService;
        this.typeService = typeService;
    }

    @Override
    public ResponseEntity<VacancyDto> create(VacancyForm form) {
        return ResponseEntity.ok().body(new VacancyDto(form.convertToEntity(typeService, parkingService)));
    }
}

package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.TypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {

    final ParkingRepository parkingRepository;

    final TypeRepository typeRepository;

    public VacancyServiceImpl(ParkingRepository parkingRepository, TypeRepository typeRepository) {
        this.parkingRepository = parkingRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public ResponseEntity<Vacancy> create(VacancyForm form) {
        return ResponseEntity.ok().body(form.convertToEntity(typeRepository, parkingRepository));
    }
}

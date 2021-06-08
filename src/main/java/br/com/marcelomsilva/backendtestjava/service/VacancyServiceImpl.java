package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Override
    public ResponseEntity<Vacancy> create(VacancyForm form) {
        return null;
    }
}

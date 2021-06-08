package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import org.springframework.http.ResponseEntity;

public interface VacancyService {
    ResponseEntity<Vacancy> create(VacancyForm form);
}

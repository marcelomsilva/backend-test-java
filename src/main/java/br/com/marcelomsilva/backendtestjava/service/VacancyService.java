package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import org.springframework.http.ResponseEntity;

public interface VacancyService {

    ResponseEntity<VacancyDto> create(VacancyForm form);
}

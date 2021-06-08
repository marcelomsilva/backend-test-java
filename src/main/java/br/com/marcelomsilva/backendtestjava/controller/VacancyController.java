package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import br.com.marcelomsilva.backendtestjava.service.VacancyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    final VacancyService service;

    public VacancyController(VacancyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Vacancy> create(@Valid VacancyForm form) {
        return service.create(form);
    }
}

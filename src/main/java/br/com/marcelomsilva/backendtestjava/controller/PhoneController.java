package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.service.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    final PhoneService service;

    public PhoneController(PhoneService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PhoneDto> create(@Valid  PhoneCreateForm form) {
        return service.create(form);
    }
}

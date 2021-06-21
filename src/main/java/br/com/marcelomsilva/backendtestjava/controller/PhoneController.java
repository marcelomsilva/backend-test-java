package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneUpdateForm;
import br.com.marcelomsilva.backendtestjava.service.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PhoneDto> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneDto> update(@PathVariable Long id, @Valid PhoneUpdateForm form) {
        return service.updateById(id, form);
    }
}

package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    final
    VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> create(@Valid VehicleForm form) {
        return service.create(form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getById(@PathVariable Long id) {
        return service.getById(id);
    }
}

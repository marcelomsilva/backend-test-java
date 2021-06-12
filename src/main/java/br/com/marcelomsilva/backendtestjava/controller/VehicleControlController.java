package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlDepartureForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.service.VehicleControlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vehicle-control")
public class VehicleControlController {

    final VehicleControlService service;

    public VehicleControlController(VehicleControlService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VehicleControlDto> create(@Valid VehicleControlEntryForm form) {
        return service.create(form);
    }

    @PostMapping("/terminate")
    public ResponseEntity<VehicleControlDto> terminate(@Valid VehicleControlDepartureForm form) {
        return service.terminate(form);
    }
}

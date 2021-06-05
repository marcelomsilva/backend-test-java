package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ParkingDto> create(@Valid ParkingForm form) {
        return service.create(form);
    }
}

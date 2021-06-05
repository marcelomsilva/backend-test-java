package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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

    @GetMapping()
    public List<ParkingDto> get() {
        return service.get();
    }
}

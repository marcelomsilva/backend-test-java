package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingUpdateForm;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<ParkingDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/pages")
    public Page<ParkingDto> getAllPages(@RequestParam(value = "page") Integer page,
                                        @RequestParam(value = "linesPerPage") Integer linesPerPage) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        return service.getAllPages(pageRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDto> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/disable/{id}")
    public ResponseEntity<ParkingDto> disableById(@PathVariable Long id) {
        return service.disableById(id);
    }

    @PutMapping("/enable/{id}")
    public ResponseEntity<ParkingDto> enableById(@PathVariable Long id) {
        return service.enableById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDto> update(@PathVariable Long id, @Valid ParkingUpdateForm form) {
        return service.update(id, form);
    }

}

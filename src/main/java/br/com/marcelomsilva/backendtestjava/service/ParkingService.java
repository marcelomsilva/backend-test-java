package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ParkingService {

    ResponseEntity<ParkingDto> create(ParkingForm form);
    List<ParkingDto> get();
}

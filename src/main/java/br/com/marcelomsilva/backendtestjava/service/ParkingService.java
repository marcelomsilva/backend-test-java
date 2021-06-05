package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import org.springframework.http.ResponseEntity;

public interface ParkingService {

    ResponseEntity<ParkingDto> create(ParkingForm form);
}

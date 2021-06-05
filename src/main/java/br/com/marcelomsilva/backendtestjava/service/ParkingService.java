package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import org.springframework.http.ResponseEntity;

public interface ParkingService {

    ResponseEntity<Parking> create(ParkingForm form);
}

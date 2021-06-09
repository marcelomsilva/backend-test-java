package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingService {

    ResponseEntity<ParkingDto> create(ParkingForm form);
    List<ParkingDto> get();
    Parking verifyAndGetById(Long id);
}

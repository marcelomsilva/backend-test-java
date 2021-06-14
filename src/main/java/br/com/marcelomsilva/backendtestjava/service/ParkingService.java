package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingService {

    ResponseEntity<ParkingDto> create(ParkingForm form);
    List<ParkingDto> getAll();
    Parking verifyAndGetById(Long id);
    ResponseEntity<ParkingDto> getById(Long id);
    ResponseEntity<ParkingDto> disableById(Long id);
    ResponseEntity<ParkingDto> enableById(Long id);
    Phone addPhone(PhoneCreateForm form);
}

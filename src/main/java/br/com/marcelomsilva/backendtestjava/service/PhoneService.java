package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneUpdateForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import org.springframework.http.ResponseEntity;

public interface PhoneService {
    void addParkingId(Phone phone, Parking parking);
    ResponseEntity<PhoneDto> create(PhoneCreateForm form);
    ResponseEntity<PhoneDto> deleteById(Long id);
    ResponseEntity<PhoneDto> updateById(Long id, PhoneUpdateForm form);
}

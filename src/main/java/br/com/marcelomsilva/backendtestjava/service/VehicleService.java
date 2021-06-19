package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleUpdateForm;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import org.springframework.http.ResponseEntity;

public interface VehicleService {

    ResponseEntity<VehicleDto> create(VehicleForm form);
    Vehicle verifyAndGetById(Long id);
    ResponseEntity<VehicleDto> getById(Long id);
    ResponseEntity<VehicleDto> disableById(Long id);
    ResponseEntity<VehicleDto> enableById(Long id);
    ResponseEntity<VehicleDto> update(Long id, VehicleUpdateForm form);
}

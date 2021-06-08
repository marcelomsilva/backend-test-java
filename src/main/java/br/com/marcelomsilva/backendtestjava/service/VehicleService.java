package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import org.springframework.http.ResponseEntity;

public interface VehicleService {

    ResponseEntity<VehicleDto> create(VehicleForm form);
}

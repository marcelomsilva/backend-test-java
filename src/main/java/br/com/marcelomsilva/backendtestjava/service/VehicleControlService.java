package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlDepartureForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import org.springframework.http.ResponseEntity;

public interface VehicleControlService {

    ResponseEntity<VehicleControlDto> create(VehicleControlEntryForm form);
    ResponseEntity<VehicleControlDto> terminate(VehicleControlDepartureForm form);
    ResponseEntity<VehicleControlDto> cancelById(Long id);
}

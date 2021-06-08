package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import org.springframework.http.ResponseEntity;

public interface VehicleControlService {

    ResponseEntity<VehicleControl> create(VehicleControlEntryForm form);
}

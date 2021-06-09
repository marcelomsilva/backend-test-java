package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleControlServiceImpl implements VehicleControlService {

    final VehicleService vehicleService;

    public VehicleControlServiceImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public ResponseEntity<VehicleControl> create(VehicleControlEntryForm form) {
        return ResponseEntity.ok().body(form.convertToEntity(vehicleService));
    }
}

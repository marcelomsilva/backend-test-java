package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlForm;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleControlServiceImpl implements VehicleControlService {

    final
    VehicleRepository vehicleRepository;

    public VehicleControlServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ResponseEntity<VehicleControl> create(VehicleControlForm form) {
        return ResponseEntity.ok().body(form.convertToEntity(vehicleRepository));
    }
}

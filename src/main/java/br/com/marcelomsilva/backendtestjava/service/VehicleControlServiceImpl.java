package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlForm;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleControlServiceImpl implements VehicleControlService {

    @Override
    public ResponseEntity<Vehicle> create(VehicleControlForm form) {
        return null;
    }
}

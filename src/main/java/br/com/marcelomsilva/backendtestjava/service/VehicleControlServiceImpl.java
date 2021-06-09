package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleControlServiceImpl implements VehicleControlService {

    final VehicleService vehicleService;

    public VehicleControlServiceImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public ResponseEntity<VehicleControlDto> create(VehicleControlEntryForm form) {
        return ResponseEntity.ok().body(new VehicleControlDto(form.convertToEntity(vehicleService)));
    }
}

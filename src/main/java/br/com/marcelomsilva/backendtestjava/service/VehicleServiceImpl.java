package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.repository.ModelRepository;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    final VehicleRepository vehicleRepository;
    final ParkingRepository parkingRepository;
    final ModelRepository modelRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ParkingRepository parkingRepository, ModelRepository modelRepository) {
        this.vehicleRepository = vehicleRepository;
        this.parkingRepository = parkingRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public ResponseEntity<VehicleDto> create(VehicleForm form) {
        return ResponseEntity.ok().body(new VehicleDto(vehicleRepository.save(form.convertToEntity(parkingRepository, modelRepository))));
    }
}

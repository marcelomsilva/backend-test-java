package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    final VehicleRepository vehicleRepository;
    final ParkingService parkingService;
    final ModelService modelService;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ParkingService parkingService, ModelService modelService) {
        this.vehicleRepository = vehicleRepository;
        this.parkingService = parkingService;
        this.modelService = modelService;
    }

    @Override
    public ResponseEntity<VehicleDto> create(VehicleForm form) {
        return ResponseEntity.ok().body(new VehicleDto(vehicleRepository.save(form.convertToEntity(parkingService, modelService))));
    }

    @Override
    public ResponseEntity<VehicleDto> getById(Long id) {
        return ResponseEntity.ok(new VehicleDto(verifyAndGetById(id)));
    }

    @Override
    public Vehicle verifyAndGetById(Long id) {
        Optional<Vehicle> optional = vehicleRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Veículo com id " + id + " não foi encontrado");
    }
}

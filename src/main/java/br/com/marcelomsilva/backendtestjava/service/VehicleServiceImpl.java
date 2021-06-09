package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Vehicle;
import br.com.marcelomsilva.backendtestjava.repository.ModelRepository;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public Vehicle verifyAndGetById(Long id) {
        Optional<Vehicle> optional = vehicleRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Veículo com id " + id + " não foi encontrado");
    }
}

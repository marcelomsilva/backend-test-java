package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface VehicleControlRepository extends CrudRepository<VehicleControl, Long> {
    Optional<VehicleControl> findByVehicleId(Long id);
    Set<VehicleControl> findAll();
}

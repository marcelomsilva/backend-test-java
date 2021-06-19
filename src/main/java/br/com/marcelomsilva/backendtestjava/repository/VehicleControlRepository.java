package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface VehicleControlRepository extends CrudRepository<VehicleControl, Long> {

    @Query("SELECT vc FROM VehicleControl vc WHERE vc.vehicle.id = ?1 AND vc.duration is null AND vc.isCancelled = false")
    Optional<VehicleControl> findNotTerminatedByVehicleId(Long id);

    Set<VehicleControl> findAll();
}

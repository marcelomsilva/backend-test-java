package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import org.springframework.data.repository.CrudRepository;

public interface VehicleControlRepository extends CrudRepository<VehicleControl, Long> {
}

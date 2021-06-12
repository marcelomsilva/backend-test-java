package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.dto.VehicleControlDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlDepartureForm;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

public interface VehicleControlRepository extends CrudRepository<VehicleControl, Long> {
    VehicleControl findByVehicleId(Long id);
}

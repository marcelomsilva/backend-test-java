package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.Parking;
import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends CrudRepository<Parking, Long> {

    Parking findByEmail(String email);
}

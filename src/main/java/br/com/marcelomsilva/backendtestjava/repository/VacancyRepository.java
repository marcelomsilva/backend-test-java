package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.Vacancy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VacancyRepository extends CrudRepository<Vacancy, Long> {

    @Query("SELECT v FROM Vacancy v WHERE v.parking.id = ?1 AND v.type.id = ?2")
    Optional<Vacancy> findParkingVacancyByTypeId(Long parkingId, Long typeId);
}

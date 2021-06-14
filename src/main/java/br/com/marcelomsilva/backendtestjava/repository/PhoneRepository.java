package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

    @Transactional
    @Modifying
    @Query("delete from Phone p where p.id = ?1")
    void deleteById(Long id);
}

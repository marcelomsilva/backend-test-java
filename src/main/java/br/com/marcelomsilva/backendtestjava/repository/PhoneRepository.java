package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}

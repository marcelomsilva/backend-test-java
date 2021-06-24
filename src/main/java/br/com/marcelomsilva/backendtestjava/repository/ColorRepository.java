package br.com.marcelomsilva.backendtestjava.repository;

import br.com.marcelomsilva.backendtestjava.entity.Color;
import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color, Long> {
}

package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Model;
import br.com.marcelomsilva.backendtestjava.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model verifyAndGetById(Long id) {
        Optional<Model> optional = modelRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Modelo com id " + id + " não foi encontrado");
    }
}

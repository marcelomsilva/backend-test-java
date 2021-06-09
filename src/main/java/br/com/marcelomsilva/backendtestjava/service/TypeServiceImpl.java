package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Type;
import br.com.marcelomsilva.backendtestjava.repository.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type verifyAndGetById(Long id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        if(optionalType.isPresent())
            return optionalType.get();
        throw new NoSuchElementException("Tipo de veículo com id " + id + "não foi encontrado");
    }
}

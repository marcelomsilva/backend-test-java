package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Color;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    final ColorRepository colorRepository;

    @Override
    public Optional<Color> verifyVehicleHasPendingControl(Long id) {
        Optional<Color> optional = colorRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Controle de veículos com id " + id + " não foi encontrado");
    }
}

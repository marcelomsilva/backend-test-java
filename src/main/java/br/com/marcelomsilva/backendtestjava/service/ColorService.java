package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Color;
import br.com.marcelomsilva.backendtestjava.entity.VehicleControl;

import java.util.Optional;

public interface ColorService {

    Color verifyAndGetById(Long id);
}

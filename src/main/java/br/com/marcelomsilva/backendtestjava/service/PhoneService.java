package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Parking;

public interface PhoneService {
    void create(String code, String number, Parking parking);
}

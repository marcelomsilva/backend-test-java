package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;

public interface PhoneService {
    void addParkingId(Phone phone, Parking parking);
}

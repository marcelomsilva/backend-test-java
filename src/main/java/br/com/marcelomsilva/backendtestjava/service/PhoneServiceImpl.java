package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void addParkingId(Phone phone, Parking parking) {
        phone.setParking(parking);
        phoneRepository.save(phone);
    }
}

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
    public void create(String code, String number, Parking parking) {
        Phone phone = new Phone(code, number, parking);
        phoneRepository.save(phone);
    }
}

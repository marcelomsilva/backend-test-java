package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.PhoneRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

    PhoneRepository phoneRepository;
    ParkingService parkingService;

    public PhoneServiceImpl(PhoneRepository phoneRepository, @Lazy ParkingService parkingService) {
        this.phoneRepository = phoneRepository;
        this.parkingService = parkingService;
    }

    @Override
    public void addParkingId(Phone phone, Parking parking) {
        phone.setParking(parking);
        phoneRepository.save(phone);
    }

    @Override
    public ResponseEntity<PhoneDto> create(PhoneCreateForm form) {
        return ResponseEntity.ok().body(new PhoneDto(phoneRepository.save(form.convertToEntity(parkingService))));
    }

    @Override
    public ResponseEntity<PhoneDto> deleteById(Long id) {
        Phone phone = verifyAndGetById(id);
        phoneRepository.deleteById(phone.getId());
        return ResponseEntity.ok().body(new PhoneDto(phone));
    }

    private Phone verifyAndGetById(Long id) {
        Optional<Phone> optional = phoneRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Estacionamento com id " + id + " não foi encontrado");
    }
}

package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.PhoneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    PhoneRepository phoneRepository;
    ParkingService parkingService;

    public PhoneServiceImpl(PhoneRepository phoneRepository, ParkingService parkingService) {
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
}

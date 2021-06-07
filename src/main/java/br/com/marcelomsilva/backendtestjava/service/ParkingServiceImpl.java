package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.PhoneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    final
    ParkingRepository parkingRepository;

    final PhoneRepository phoneRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository, PhoneRepository phoneRepository) {
        this.parkingRepository = parkingRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public ResponseEntity<ParkingDto> create(ParkingForm form) {
        Parking parking = parkingRepository.save(form.convertToEntity());
        Phone phone = new Phone(form.getPhoneCode(), form.getPhoneNumber(), parking);
        phoneRepository.save(phone);
        return ResponseEntity.ok().body(new ParkingDto(parking));
    }

    @Override
    public List<ParkingDto> get() {
        List<Parking> list = (List<Parking>) parkingRepository.findAll();
        return list.stream().map(p -> new ParkingDto(p)).collect(Collectors.toList());
    }

}

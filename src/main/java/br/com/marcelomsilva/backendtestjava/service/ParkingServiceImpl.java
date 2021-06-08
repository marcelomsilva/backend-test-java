package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    final ParkingRepository parkingRepository;

    final PhoneService phoneService;

    public ParkingServiceImpl(ParkingRepository parkingRepository, PhoneService phoneService) {
        this.parkingRepository = parkingRepository;
        this.phoneService = phoneService;
    }

    @Override
    public ResponseEntity<ParkingDto> create(ParkingForm form) {
        Phone phone = new Phone(form.getPhoneCode(), form.getPhoneNumber());
        Parking parking = form.convertToEntity(phone);
        parkingRepository.save(parking);
        phoneService.addParkingId(phone, parking);
        return ResponseEntity.ok().body(new ParkingDto(parking));
    }

    @Override
    public List<ParkingDto> get() {
        List<Parking> list = (List<Parking>) parkingRepository.findAll();
        return list.stream().map(p -> new ParkingDto(p)).collect(Collectors.toList());
    }

}

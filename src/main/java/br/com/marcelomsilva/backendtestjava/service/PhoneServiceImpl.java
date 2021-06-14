package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneUpdateForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;

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
        Phone phone = parkingService.addPhone(form);
        return ResponseEntity.ok().body(new PhoneDto(phone));
    }

    @Override
    public ResponseEntity<PhoneDto> deleteById(Long id) {
        Phone phone = verifyAndGetById(id);
        verifySizePhoneList(phone.getParking().getId());
        phoneRepository.deleteById(id);
        return ResponseEntity.ok().body(new PhoneDto(phone));
    }

    @Override
    public ResponseEntity<PhoneDto> updateById(Long id, PhoneUpdateForm form) {
        Phone phone = verifyAndGetById(id);
        phone.setCode(form.getCode());
        phone.setNumber(form.getNumber());
        phoneRepository.save(phone);
        return ResponseEntity.ok().body(new PhoneDto(phone));
    }

    private Phone verifyAndGetById(Long id) {
        Optional<Phone> optional = phoneRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Telefone com id " + id + " não foi encontrado");
    }

    private void verifySizePhoneList(Long parkingId) {
        Parking parking = parkingService.verifyAndGetById(parkingId);
        System.out.println(parking.getPhones().size());
        if(parking.getPhones().size() == 1) {
            throw new IllegalTransactionStateException("Esse estacionamento deve ter mais de um Telefone cadastrado");
        }
    }


}

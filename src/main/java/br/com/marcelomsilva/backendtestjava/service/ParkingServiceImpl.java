package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingUpdateForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService, UserDetailsService {

    final ParkingRepository parkingRepository;
    final PhoneService phoneService;
    final AddressService addressService;

    public ParkingServiceImpl(ParkingRepository parkingRepository, PhoneService phoneService, AddressService addressService) {
        this.parkingRepository = parkingRepository;
        this.phoneService = phoneService;
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<ParkingDto> create(ParkingForm form) {
        Phone phone = phoneService.build(form.getPhoneCode(), form.getPhoneNumber());
        Address address = addressService.build(form.getZipCode(), form.getPublicPlace(), form.getNumber(),
                form.getCity(), form.getState(), form.getNeighborhood(), form.getComplement());
        Parking parking = form.convertToEntity(address, phone);
        parkingRepository.save(parking);
        phoneService.addParkingId(phone, parking);
        return ResponseEntity.ok().body(new ParkingDto(parking));
    }

    @Override
    public List<ParkingDto> getAll() {
        List<Parking> list = (List<Parking>) parkingRepository.findAll();
        return list.stream().map(p -> new ParkingDto(p)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ParkingDto> getById(Long id) {
        return ResponseEntity.ok(new ParkingDto(verifyAndGetById(id)));
    }

    @Override
    public ResponseEntity<ParkingDto> disableById(Long id) {
        Parking parking = verifyAndGetById(id);
        parking.setIsActive(false);
        parkingRepository.save(parking);
        return ResponseEntity.ok(new ParkingDto(parking));
    }

    @Override
    public ResponseEntity<ParkingDto> enableById(Long id) {
        Parking parking = verifyAndGetById(id);
        parking.setIsActive(true);
        parkingRepository.save(parking);
        return ResponseEntity.ok(new ParkingDto(parking));
    }

    @Override
    public Phone addPhone(PhoneCreateForm form) {
        Phone phone = form.convertToEntity(this);
        Parking parking = verifyAndGetById(form.getParkingId());
        parking.addPhone(phone);
        parkingRepository.save(parking);
        return parking.getPhones().stream()
                .filter(p -> p.equals(phone))
                .findFirst().get();
    }

    @Override
    public ResponseEntity<ParkingDto> update(Long id, ParkingUpdateForm form) {
        Parking parking = verifyAndGetById(id);
        parking.setCnpj(form.getCnpj());
        parking.setName(form.getName());
        Address address = addressService.update(parking.getAddress(), form);
        parking.setAddress(address);
        parkingRepository.save(parking);
        return ResponseEntity.ok(new ParkingDto(parking));
    }

    @Override
    public Page<ParkingDto> getAllPages(PageRequest pageRequest) {
        Page<Parking> parkings = parkingRepository.findAllPages(pageRequest);
        return parkings.map(p -> new ParkingDto(p));
    }

    @Override
    public Parking verifyAndGetById(Long id) {
        Optional<Parking> optional = parkingRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        throw new NoSuchElementException("Estacionamento com id " + id + " não foi encontrado");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Parking parking = parkingRepository.findByEmail(email);
        if(parking == null)
            throw new UsernameNotFoundException("Usuário não encontrado");
        return parking;
    }
}
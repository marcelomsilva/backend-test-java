package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.PhoneDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import br.com.marcelomsilva.backendtestjava.service.PhoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhoneServiceTest {

    @Autowired
    PhoneService service;

    @Autowired
    ParkingService parkingService;

    @Autowired
    ParkingRepository parkingRepository;

    @Test
    public void create() {
        ParkingForm parkingForm = new ParkingForm("Teste teste22", "123454856", "email999", "password","12348899", "Rua Joao da Costa 2",
                "321", "Sao ", "SP", "Jardim Cruz y", "", "1256", "4234234989");
        ParkingDto parking = parkingService.create(parkingForm).getBody();
        PhoneCreateForm form = new PhoneCreateForm("11", "1515151", parking.getId());
        assertEquals(200, service.create(form).getStatusCodeValue());
    }

    @Test
    public void delete() {
        ParkingForm parkingForm = new ParkingForm("Teste2 dv", "354", "email43432", "password","12993563", "Rua Joao",
                "3", "Paulo", "RJ", "Jardim ", "fdsf", "56", "26324777");
        Parking parking = parkingService.verifyAndGetById(parkingService.create(parkingForm).getBody().getId());
        PhoneCreateForm phoneCreateForm = new PhoneCreateForm("13", "54889798", parking.getId());
        service.create(phoneCreateForm).getBody().getNumber();
        Long phoneId = service.create(phoneCreateForm).getBody().getId();
        parkingRepository.save(parking);
        assertEquals(200, service.deleteById(phoneId).getStatusCodeValue());
    }
}

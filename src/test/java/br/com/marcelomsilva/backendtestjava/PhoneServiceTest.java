package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import br.com.marcelomsilva.backendtestjava.service.PhoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create() {
        ParkingForm parkingForm = new ParkingForm("Teste", "123454856", "123488", "Rua Joao da Costa 2",
                "321", "Sao Paulo", "SP", "Jardim Cruz y", "", "1256", "4234234989");
        ParkingDto parking = parkingService.create(parkingForm).getBody();
        PhoneCreateForm form = new PhoneCreateForm("11", "1515151", parking.getId());
        assertEquals(200, service.create(form).getStatusCodeValue());
    }

    @Test
    public void delete() {
        ParkingForm parkingForm = new ParkingForm("Teste2", "54354", "123488535", "Rua Joao da ",
                "321", "Sao Paulo", "SP", "Jardim ", "", "1256", "4234234989");
        parkingService.create(parkingForm).getBody();
        assertEquals(200, service.deleteById(1L).getStatusCodeValue());
    }
}

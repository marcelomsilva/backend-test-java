package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.entity.Phone;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ParkingServiceTest {

    @Autowired
    ParkingService service;

    @Test
    public void createTest() {
        ParkingForm form = new ParkingForm("Teste", "123454856", "123488", "Rua Joao da Costa 2",
                "321", "Sao Paulo", "SP", "Jardim Cruz y", "", "1256", "4234234989");
        assertEquals(200, service.create(form).getStatusCodeValue());
    }

    @Test
    public void getById() {
        ParkingForm form = new ParkingForm("Nome Teste", "123456", "123", "Rua Joao da Costa",
                "321", "Sao Paulo", "SP", "Jardim Cruz", "", "12", "4234234");
        ResponseEntity<ParkingDto> parkingDtoResponseEntity = service.create(form);
        service.getById(parkingDtoResponseEntity.getBody().getId());
    }

    @Test void disableById() {
        ParkingForm form = new ParkingForm("Nome Teste", "123456", "123", "Rua Joao da Costa",
                "321", "Sao Paulo", "SP", "Jardim Cruz", "", "12", "4234234");
        Long parkingId = service.create(form).getBody().getId();
        service.disableById(parkingId);
    }
}

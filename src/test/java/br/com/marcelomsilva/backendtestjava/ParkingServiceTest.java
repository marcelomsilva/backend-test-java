package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.dto.form.ParkingUpdateForm;
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
        ParkingForm form = new ParkingForm("Teste teste teste", "12986598888", "email2", "password2", "12348899", "Rua oao da Costa 2",
                "3985", "Sao Paulo minas", "MG", "Jardim Cruz Z", "", "1256", "4234234989");
        assertEquals(200, service.create(form).getStatusCodeValue());
    }

    @Test
    public void getById() {
        ParkingForm form = new ParkingForm("Nome Teste", "123456", "email2543", "password2","12345879", "Rua Joao da Costa",
                "321", "Sao Paulo", "SP", "Jardim Cruz", "", "12", "4234234");
        ResponseEntity<ParkingDto> parkingDtoResponseEntity = service.create(form);
        service.getById(parkingDtoResponseEntity.getBody().getId());
    }

    @Test
    public void disableById() {
        ParkingForm form = new ParkingForm("Nome Teste Novamente", "1234569888", "email3", "password3","12345678", "Rua Joao da Costa",
                "321", "Sao Paulo", "SP", "Jardim Cruz", "", "12", "4234234");
        Long parkingId = service.create(form).getBody().getId();
        service.disableById(parkingId);
    }

    @Test
    public void update() {
        ParkingForm form = new ParkingForm("Nome htrhrt", "12345665464", "email4", "password4","12345678", "Rua Joao da Costa",
                "321", "Sao Paulo Alto", "SP", "Jardim Souza lima Cruz", "", "125435", "4235534234");
        ParkingDto parking = service.create(form).getBody();
        ParkingUpdateForm formUpdate = new ParkingUpdateForm("Nome teste", "12345678", "12345678", "Rua Joao",
                "321", "Sao Paulo Baixo", "RJ", "448", "teste");
        ParkingDto parkingUpdate = service.update(parking.getId(), formUpdate).getBody();
        assertEquals(false , parking.equals(parkingUpdate));

    }
}

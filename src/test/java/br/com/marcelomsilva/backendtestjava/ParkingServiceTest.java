package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.ParkingForm;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ParkingServiceTest {

    @Autowired
    ParkingService service;



    @Test
    public void createTest() {
        ParkingForm form = new ParkingForm("Nome Teste", "123456", "123", "Rua Joao da Costa",
                "321", "Sao Paulo", "SP", "Jardim Cruz", "", "12", "4234234");
        assertEquals(200, service.create(form).getStatusCodeValue());
    }

    @Test
    public void getById() {
        service.getById(1L);
    }
}

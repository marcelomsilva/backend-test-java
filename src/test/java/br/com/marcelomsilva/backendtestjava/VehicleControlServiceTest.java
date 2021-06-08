package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlForm;
import br.com.marcelomsilva.backendtestjava.service.VehicleControlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleControlServiceTest {

    @Autowired
    VehicleControlService service;

    @Test
    public void create() {
        assertEquals(200, service.create(new VehicleControlForm(1L, Instant.now())).getStatusCodeValue());
    }
}

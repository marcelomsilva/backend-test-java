package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VehicleServiceTest {

    @Autowired
    VehicleService service;

    @Test
    public void createTest() {
    }
}

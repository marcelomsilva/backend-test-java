package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.ParkingDto;
import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.entity.Color;
import br.com.marcelomsilva.backendtestjava.repository.ColorRepository;
import br.com.marcelomsilva.backendtestjava.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleServiceTest {

    @Autowired
    VehicleService service;

    @Autowired
    ColorRepository colorRepository;

    private Color color;

    @BeforeEach
    private void createColor() {
        this.color = new Color("teste");
        colorRepository.save(color);
    }

    @Test
    public void createTest() {
        VehicleForm form = new VehicleForm("drwew48", color.getId(),1L, 1L);
        assertEquals(200, service.create(form).getStatusCodeValue());
    }

    @Test
    public void getById() {
        VehicleForm form = new VehicleForm("gurr13", color.getId(),1L, 1L);
        Long vehicleId = service.create(form).getBody().getId();
        service.getById(vehicleId);
    }
}

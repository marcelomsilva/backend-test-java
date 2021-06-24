package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.VacancyDto;
import br.com.marcelomsilva.backendtestjava.dto.VehicleDto;
import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleControlEntryForm;
import br.com.marcelomsilva.backendtestjava.dto.form.VehicleForm;
import br.com.marcelomsilva.backendtestjava.entity.*;
import br.com.marcelomsilva.backendtestjava.repository.ColorRepository;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import br.com.marcelomsilva.backendtestjava.service.VacancyService;
import br.com.marcelomsilva.backendtestjava.service.VehicleControlService;
import br.com.marcelomsilva.backendtestjava.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleControlServiceTest {

    @Autowired
    VehicleControlService service;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VacancyService vacancyService;

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    ColorRepository colorRepository;

    @Test
    public void create() {
        // Create Parking
        Address address = Mockito.mock(Address.class);
        Phone phone = Mockito.mock(Phone.class);
        Parking parking = new Parking("estacionamento", "123", "email", "password",address, phone);
        parkingRepository.save(parking);

        //Create Color
        Color color = new Color("teste");
        colorRepository.save(color);

        VehicleForm form = new VehicleForm("drwew48", color.getId(), parking.getId(), 1L);
        VehicleDto vehicle = vehicleService.create(form).getBody();
        vacancyService.create(new VacancyForm(10, 2L, parking.getId())).getBody();
        assertEquals(200, service.create(new VehicleControlEntryForm(vehicle.getId(), Instant.now())).getStatusCodeValue());
    }
}

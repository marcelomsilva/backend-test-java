package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.*;
import br.com.marcelomsilva.backendtestjava.repository.VacancyRepository;
import br.com.marcelomsilva.backendtestjava.service.ParkingService;
import br.com.marcelomsilva.backendtestjava.service.TypeService;
import br.com.marcelomsilva.backendtestjava.service.VacancyService;
import br.com.marcelomsilva.backendtestjava.service.VacancyServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacancyServiceTest {

    @Autowired
    VacancyServiceImpl service;

    @Autowired
    @Mock
    VacancyRepository vacancyRepository;

    @Mock
    @Autowired
    ParkingService parkingService;

    @Mock
    @Autowired
    TypeService typeService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create() {
        assertEquals(200, service.create(new VacancyForm(20, 1L, 1L)).getStatusCodeValue());
    }


    @Test
    public void incrementAmountOccupied() throws Exception {
        this.service = new VacancyServiceImpl(vacancyRepository, parkingService, typeService);
        VehicleControl vehicleControl = createVehicleControl();
        service.incrementAmountOccupied(vehicleControl);
        Mockito.verify(vacancyRepository).save(vehicleControl.getParkingVacancies().stream().findAny().get());
    }

    private VehicleControl createVehicleControl() {
        Address address = Mockito.mock(Address.class);
        Phone phone = Mockito.mock(Phone.class);
        Parking parking = new Parking("estacionamento", "123", address, phone);
        Brand brand = Mockito.mock(Brand.class);
        Type type = new Type("foo");
        Model model = new Model("teste", brand, type);
        Vacancy vacancy = new Vacancy(1, type, parking);
        Vehicle vehicle =  new Vehicle("DTE3432", parking, model);
        parking.addVacancy(vacancy);
        return new VehicleControl(vehicle, Instant.now());
    }



}

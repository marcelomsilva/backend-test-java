package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.entity.*;
import br.com.marcelomsilva.backendtestjava.repository.ModelRepository;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.repository.VacancyRepository;
import br.com.marcelomsilva.backendtestjava.repository.VehicleRepository;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class VacancyServiceTest {

    @Autowired
    VacancyServiceImpl service;

    @Autowired
    VacancyRepository vacancyRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingRepository parkingRepository;

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
        VehicleControl vehicleControl = createVehicleControl("increment");
        service.incrementAmountOccupied(vehicleControl);
        assertEquals(1, service.getVacancyByTypeId(vehicleControl).getAmountOccupied());
    }

    @Test
    public void decrementAmountOccupied() throws Exception {
        VehicleControl vehicleControl = createVehicleControl("decrement");
        service.incrementAmountOccupied(vehicleControl);
        service.decrementAmountOccupied(vehicleControl);
        assertEquals(0, service.getVacancyByTypeId(vehicleControl).getAmountOccupied());
    }

    @Test
    public void decrementAmountOccupiedException() throws Exception {
        VehicleControl vehicleControl = createVehicleControl("decrementException");
        assertThrows(IllegalArgumentException.class, () -> service.decrementAmountOccupied(vehicleControl));
    }

    private VehicleControl createVehicleControl(String option) {
        // Create Parking
        Address address = Mockito.mock(Address.class);
        Phone phone = Mockito.mock(Phone.class);
        Parking parking = new Parking("estacionamento", "123"+option, "email"+option, "password",address, phone);
        parkingRepository.save(parking).getId();

        // Create Model
        Brand brand = Mockito.mock(Brand.class);
        Type type = new Type("foo"+option);
        Model model = new Model("teste"+option, brand, type);
        modelRepository.save(model);

        // Create Vehicle
        Vehicle vehicle =  new Vehicle("DTE3432", parking, model);
        vehicleRepository.save(vehicle);

        // Create and set Vacancy
        Vacancy vacancy = new Vacancy(1, type, parking);
        vacancyRepository.save(vacancy);

        return new VehicleControl(vehicle, Instant.now());
    }



}

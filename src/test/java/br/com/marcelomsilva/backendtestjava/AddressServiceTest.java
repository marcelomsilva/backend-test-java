package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressServiceTest {

    AddressService service;

    @Test
    public void getByZipCode() {
        Address address = service.getByZipCode("11453010");
        assertEquals("11453010", address.getZipcode());
    }
}

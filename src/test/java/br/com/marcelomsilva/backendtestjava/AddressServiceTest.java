package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.entity.Address;
import br.com.marcelomsilva.backendtestjava.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    AddressService service;

    @Test
    public void getByZipCodeApiViaCep() {
        Address address = service.getByZipCodeApiViaCep("01001000");
        assertEquals("01001-000", address.getZipcode());
    }
}

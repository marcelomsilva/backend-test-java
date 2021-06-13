package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.PhoneCreateForm;
import br.com.marcelomsilva.backendtestjava.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhoneServiceTest {

    PhoneService service;

    @Test
    public void create() {
        PhoneCreateForm form = new PhoneCreateForm("11", "1515151", 1L);
        assertEquals(200, service.create(form).getStatusCodeValue());
    }
}

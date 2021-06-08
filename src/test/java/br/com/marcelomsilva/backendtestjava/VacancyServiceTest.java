package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.service.VacancyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacancyServiceTest {

    @Autowired
    VacancyService service;

    @Test
    public void create() {
        assertEquals(200, service.create(new VacancyForm(20, 1L, 1L)).getStatusCodeValue());
    }
}

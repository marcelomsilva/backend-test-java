package br.com.marcelomsilva.backendtestjava;

import br.com.marcelomsilva.backendtestjava.dto.form.VacancyForm;
import br.com.marcelomsilva.backendtestjava.service.VacancyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VacancyServiceTest {

    @Autowired
    VacancyService vacancyService;

    @Test
    public void create() {
        vacancyService.create(new VacancyForm(20, 1L, 1L));
    }
}

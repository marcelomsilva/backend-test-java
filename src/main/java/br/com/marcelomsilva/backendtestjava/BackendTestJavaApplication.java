package br.com.marcelomsilva.backendtestjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@EnableSwagger2
@RestController
public class BackendTestJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestJavaApplication.class, args);
	}

	@RequestMapping("")
	public void redirect(HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Location", "/swagger-ui.html");
		httpServletResponse.setStatus(302);
	}

}

package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.form.LoginForm;
import br.com.marcelomsilva.backendtestjava.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> auth(@RequestBody @Valid LoginForm form) {
        return service.login(form);
    }
}

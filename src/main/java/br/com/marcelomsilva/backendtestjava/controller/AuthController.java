package br.com.marcelomsilva.backendtestjava.controller;

import br.com.marcelomsilva.backendtestjava.dto.form.AuthForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody @Valid AuthForm form) {
        System.out.println(form.getEmail());
        System.out.println(form.getPassword());
        return null;
    }
}

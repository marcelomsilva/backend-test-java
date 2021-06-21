package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.AuthForm;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(AuthForm form);
}

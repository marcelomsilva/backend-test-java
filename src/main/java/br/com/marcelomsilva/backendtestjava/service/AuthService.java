package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.TokenDto;
import br.com.marcelomsilva.backendtestjava.dto.form.LoginForm;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<TokenDto> login(LoginForm form);
}

package br.com.marcelomsilva.backendtestjava.service;

import org.springframework.security.core.Authentication;

public interface TokenService {

    String generateToken(Authentication authentication);
    Boolean tokenIsValid(String token);
}

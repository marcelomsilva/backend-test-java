package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.form.AuthForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    final AuthenticationManager authManager;
    final TokenService tokenService;

    public AuthServiceImpl(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity<?> login(AuthForm form) {
        UsernamePasswordAuthenticationToken dataLogin = form.convertToAuth();
        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException exception) {
            throw new UsernameNotFoundException("Login e senha incorretos");
        }
    }
}

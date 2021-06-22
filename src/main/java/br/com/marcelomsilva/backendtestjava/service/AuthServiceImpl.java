package br.com.marcelomsilva.backendtestjava.service;

import br.com.marcelomsilva.backendtestjava.dto.TokenDto;
import br.com.marcelomsilva.backendtestjava.dto.form.LoginForm;
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
    public ResponseEntity<TokenDto> login(LoginForm form) {
        UsernamePasswordAuthenticationToken dataLogin = form.convertToAuth();
        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok().body(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException exception) {
            throw new UsernameNotFoundException("Login e senha incorretos");
        }
    }
}

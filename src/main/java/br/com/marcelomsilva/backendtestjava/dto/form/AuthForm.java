package br.com.marcelomsilva.backendtestjava.dto.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthForm {

    @NotNull @NotEmpty
    private String email;

    @NotNull @NotEmpty
    private String password;


    public AuthForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UsernamePasswordAuthenticationToken convertToAuth() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}

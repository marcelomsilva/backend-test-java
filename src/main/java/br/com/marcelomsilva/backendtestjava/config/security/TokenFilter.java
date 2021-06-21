package br.com.marcelomsilva.backendtestjava.config.security;

import br.com.marcelomsilva.backendtestjava.entity.Parking;
import br.com.marcelomsilva.backendtestjava.repository.ParkingRepository;
import br.com.marcelomsilva.backendtestjava.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {

    TokenService tokenService;
    ParkingRepository parkingRepository;

    public TokenFilter(TokenService tokenService, ParkingRepository parkingRepository) {
        this.tokenService = tokenService;
        this.parkingRepository = parkingRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if(tokenService.tokenIsValid(token))
            authenticate(token);
        filterChain.doFilter(request, response);
    }

    private void authenticate(String token) {
        Long userId = tokenService.getUserToken(token);
        Parking user = parkingRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), null, user.getRole());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer"))
            return null;
        return token.substring(7, token.length());
    }
}

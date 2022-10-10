package dev.struchkov.controllers;

import dev.struchkov.models.JwtRequest;
import dev.struchkov.models.JwtResponse;
import dev.struchkov.models.RefreshJwtRequest;
import dev.struchkov.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public JwtResponse login(@RequestBody JwtRequest authRequest) throws AuthException {
        return authService.login(authRequest);
    }

    @PostMapping("token")
    public JwtResponse getToken(@RequestBody RefreshJwtRequest refreshJwtRequest) throws AuthException {
        return authService.getAccessToken(refreshJwtRequest.getRefreshToken());
    }

    @PostMapping("refresh")
    public JwtResponse refresh(@RequestBody RefreshJwtRequest refreshJwtRequest) throws AuthException {
        return authService.refresh(refreshJwtRequest.getRefreshToken());
    }

}

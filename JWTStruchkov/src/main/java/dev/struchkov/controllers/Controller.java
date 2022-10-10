package dev.struchkov.controllers;

import dev.struchkov.models.JwtAuthentication;
import dev.struchkov.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Controller {

    private final AuthService authService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public String helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return "Hello user " + authInfo.getPrincipal() + "!";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("hello/admin")
    public String helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return "Hello admin " + authInfo.getPrincipal() + "!";
    }

}

package dev.struchkov.controllers;

import dev.struchkov.dtos.UserDto;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Hidden
@RestController
@RequestMapping("/secret")
@Tag(name = "Secret controller", description = "Allow to delete all users")
public class SecretController {

    private final Map<String, UserDto> repository;

    public SecretController(Map<String, UserDto> repository) {
        this.repository = repository;
    }

    @GetMapping(value = "destroy")
    public HttpStatus destroy() {
        repository.clear();
        return HttpStatus.OK;
    }

}

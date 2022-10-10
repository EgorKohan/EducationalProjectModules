package com.baeldung.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class CorsRestController {

    @GetMapping
    @CrossOrigin
    public String sayHello() {
        return "Hello";
    }

}

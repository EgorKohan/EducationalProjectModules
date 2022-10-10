package com.baeldung.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/login/oauth2/code/google")
    public String sayHelloGoogle() {
        return "Hello, Google";
    }

}

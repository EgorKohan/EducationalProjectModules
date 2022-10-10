package com.my.test.controllers;

import com.my.test.models.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping(consumes = {"multipart/form-data"})
    public void saveUser(@ModelAttribute User user) {
        System.out.println(user);
    }

}

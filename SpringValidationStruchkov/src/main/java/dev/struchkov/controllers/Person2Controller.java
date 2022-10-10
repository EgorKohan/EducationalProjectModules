package dev.struchkov.controllers;

import dev.struchkov.dtos.PersonDto2;
import dev.struchkov.validation.Marker;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/person2")
public class Person2Controller {

    @PostMapping
    @Validated({Marker.OnCreate.class})
    public ResponseEntity<String> create(@Valid @RequestBody PersonDto2 personDto2){
        return ResponseEntity.ok("valid");
    }

    @PutMapping
    @Validated({Marker.OnUpdate.class})
    public ResponseEntity<String> update(@Valid @RequestBody PersonDto2 personDto2){
        return ResponseEntity.ok("valid");
    }

}

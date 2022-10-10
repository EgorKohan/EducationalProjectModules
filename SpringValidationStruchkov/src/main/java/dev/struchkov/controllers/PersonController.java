package dev.struchkov.controllers;

import dev.struchkov.dtos.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    public ResponseEntity<String> getOK(@Valid @RequestBody PersonDto personDto) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable @Min(1) Integer id){
        return ResponseEntity.ok("valid");
    }

}

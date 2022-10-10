package com.habr.controllers;

import com.habr.models.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Person", description = "The Person API")
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final List<Person> personList = new ArrayList<>();

    @Operation(summary = "Gets all persons", tags = "person2")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the persons",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = Person.class
                                            )
                                    )
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Method not allowed",
                    content = @Content
            )
    })
    @GetMapping
    public List<Person> getAll() {
        return personList;
    }

    @Operation(summary = "Create a new person", tags = "person3")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "New person was created"
            )
    })
    @PostMapping
    public Person create(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Person body") @RequestBody Person person) {
        personList.add(person);
        return person;
    }

}

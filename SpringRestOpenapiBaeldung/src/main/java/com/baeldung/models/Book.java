package com.baeldung.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class Book {

    @JsonIgnore
    private String id;

    @NotBlank(message = "Name cannot be null or blank")
    private String name;

    @Min(1)
    @Max(20)
    private int age;

    @NotBlank(message = "Author cannot be null or blank")
    private String author;

}

package com.baeldung.models;

import lombok.Data;

@Data
public class CarDto {

    private int id;

    private String name;

    private FuelType fuelType;

}

package com.baeldung.models.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class UtilityVehicle extends Vehicle{

    @Setter
    @Getter
    private Integer countOfWheels;

}

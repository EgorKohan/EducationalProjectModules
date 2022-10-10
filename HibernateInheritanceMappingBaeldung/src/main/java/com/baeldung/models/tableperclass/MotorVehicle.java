package com.baeldung.models.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class MotorVehicle extends Vehicle {

    @Setter
    @Getter
    private Integer powerOfEngine;

}

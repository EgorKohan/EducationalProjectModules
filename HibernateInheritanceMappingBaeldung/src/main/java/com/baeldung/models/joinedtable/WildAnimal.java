package com.baeldung.models.joinedtable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
public class WildAnimal extends Animal{

    @Getter
    @Setter
    private Integer attack;

}

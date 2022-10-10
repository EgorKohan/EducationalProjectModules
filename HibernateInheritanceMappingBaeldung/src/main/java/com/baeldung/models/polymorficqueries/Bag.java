package com.baeldung.models.polymorficqueries;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.Entity;

@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class Bag extends Item {

    @Setter
    @Getter
    private float weight;

}

package com.baeldung.models.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Pen extends MyProduct{

    @Getter
    @Setter
    private String color;

}

package com.baeldung.models.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Book extends MyProduct{

    @Getter
    @Setter
    private String author;

}

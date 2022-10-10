package com.baeldung.models;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ContactPerson {

    private String firstName;

    private String lastName;

    private String phone;

}

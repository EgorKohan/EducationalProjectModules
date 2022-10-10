package com.test.web.repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("super_person")
public class SuperPerson extends Person{

    public SuperPerson(String id, String name) {
        super(id, name);
    }
}

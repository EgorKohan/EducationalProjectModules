package com.test.web.repository;

import lombok.Data;

@Data
public class Person {

    protected String id;

    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

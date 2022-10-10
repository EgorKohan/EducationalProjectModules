package com.baeldung.models;

import lombok.Data;

@Data
public class TestClass {

    private String name;

    private TestClassType type;

    public TestClass(String name) {
        this.name = name;
    }
}

package com.baeldung.models;

import lombok.Getter;

public enum TestClassType {
    TC1("tc1"), TC2("tc2");

    @Getter
    private final String type;

    TestClassType(String type) {
        this.type = type;
    }
}

package main;

import lombok.Getter;

public final class CustomEnum {

    @Getter
    private final String name;

    private CustomEnum(String name) {
        this.name = name;
    }

    public static CustomEnum EGOR = new CustomEnum("Egor");
    public static CustomEnum DIMA = new CustomEnum("Dima");

}

package main;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JetBulbInterview {

    public static final String MERCURY = "Mercury";
    public static final String GOD = "God";

    static void drawGod(String name) {
        System.out.println("Hi, I'm " + name);
    }

    public static void main(String[] args) {
        System.out.println(Names.GODS.getNames());
        System.out.println(Names.PLANETS.getByName("Mars"));

        // Енам может помочь нам ограничить передаваемые значения по типу

    }

}

enum Names {
    GODS(Arrays.asList("Mercury", "Mars")), PLANETS(Arrays.asList("Mercury", "Mars")), CHOCOLATES(Collections.singletonList("Mars"));

    @Getter
    private final List<String> names;

    Names(List<String> names) {
        this.names = names;
    }

    public String getByName(String name) {
        if (names.contains(name)) return name;
        else return null;
    }

}
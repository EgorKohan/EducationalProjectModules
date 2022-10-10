package main.tests;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <img src="https://habrastorage.org/r/w1560/webt/ks/kr/yi/kskryittdimovhicuavhnx4z7se.png"/>
 */

public class App {
    public static void main(String[] args) {
        int id = 23;
        String pName = "Jon";
        Person p = null;
        p = new Person(id, pName);
    }
}

@Data
@AllArgsConstructor
class Person {
    int pid;
    String name;

    // constructors, getters/setters
}
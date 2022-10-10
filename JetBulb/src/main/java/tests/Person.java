package tests;

import lombok.Data;

@Data
public class Person {

    private String name;

    public Person() {
        System.out.println("Hello");
    }

    public Person(String name) {
        System.out.println("Hello 1");
        this.name = name;
    }

    protected void sayJustHello() {
        System.out.println("Hello I'm just a user!");
    }


}

package com.test.powermockito;

public class SomeClass {

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return sub(a, b);
    }

    private int sub(int a, int b) {
        return a - b;
    }

}

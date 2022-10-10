package com.habr;

import org.springframework.stereotype.Component;

@Component
public class Pojo {

    @Loggable
    public void test() {
        System.out.println("Test method called");
        this.testUtil();
    }

    @Loggable
    public void testUtil() {
        System.out.println("TestUtil method called");
    }

}

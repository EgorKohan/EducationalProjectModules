package com.test.generics;

import java.util.ArrayList;
import java.util.List;

public class TestServiceImpl implements TestService {

    @Override
    public List<TestClass1> getTestInterfaces() {
        List<TestClass1> testClasses = new ArrayList<>();
        testClasses.add(new TestClass1(1, "Egor"));
        testClasses.add(new TestClass1(2, "Egor"));
        return testClasses;
    }

}

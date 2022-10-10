package com.test.generics;

import java.util.Arrays;
import java.util.List;

public class IntegerClass implements SomeInterface<Integer> {

    @Override
    public Integer getValue() {
        return 1;
    }

    @Override
    public List<Number> getNumbers() {
        return Arrays.asList(1, 2, 3);
    }
}

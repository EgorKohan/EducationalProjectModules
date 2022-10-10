package com.test.generics;

import java.util.Arrays;
import java.util.List;

public class DoubleClass implements SomeInterface<Double> {
    @Override
    public Double getValue() {
        return 1.0D;
    }

    @Override
    public List<Number> getNumbers() {
        return Arrays.asList(1.0D, 2.0D);
    }

}

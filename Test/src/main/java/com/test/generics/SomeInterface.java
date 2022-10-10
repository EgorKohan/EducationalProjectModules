package com.test.generics;

import java.util.List;

public interface SomeInterface<E extends Number> {

    E getValue();

    List<Number> getNumbers();

}

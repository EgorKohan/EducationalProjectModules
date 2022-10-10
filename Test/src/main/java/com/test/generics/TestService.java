package com.test.generics;

import java.util.List;

public interface TestService {

    List<? extends TestInterface1> getTestInterfaces();

}

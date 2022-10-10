package com.test.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestClass1 implements TestInterface1 {

    private Integer id;

    private String name;

}

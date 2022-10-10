package com.baeldung;

import com.baeldung.mappers.TestClassMapper;
import com.baeldung.models.TestClass;
import com.baeldung.models.TestClassDto;
import com.baeldung.models.TestClassType;
import org.junit.jupiter.api.Test;

class TestClassTest {

    private final TestClassMapper testClassMapper = TestClassMapper.INSTANCE;

    @Test
    void test() {
        TestClass testClass = new TestClass("Test1");
        TestClassDto testClassDto = new TestClassDto("Test2");

        TestClass testClass1 = testClassMapper.toTestClass(testClassDto, TestClassType.TC1);
        TestClassDto testClassDto1 = testClassMapper.toDto(testClass);

        System.out.println("The end");

    }

}

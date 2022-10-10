//package com.test.web.powermockito;
//
//import com.test.powermockito.SomeClass;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class PowerMockTest {
//
//    @Spy
//    private SomeClass someClass;
//
//    @BeforeAll
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    @SneakyThrows
//    @PrepareForTest(SomeClass.class)
//    void test1() {
////        PowerMockito.verifyPrivate(someClass, Mockito.only()).invoke("sub", eq(2), eq(1));
//        PowerMockito.when(someClass, "sub", Mockito.anyInt(), Mockito.anyInt()).thenReturn(10000);
//        System.out.println(someClass.subtraction(2, 1));
//    }
//
//}

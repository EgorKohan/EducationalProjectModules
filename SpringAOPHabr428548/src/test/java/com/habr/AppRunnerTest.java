package com.habr;

import com.habr.services.MyService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AppRunnerTest {

    @Autowired
    private MyService myService;

    @Test
    void test(){
        List<String> list = new ArrayList<>();
        list.add("test");

        myService.method1(list);
        myService.method2();
        Assert.assertTrue(myService.check());
    }

}

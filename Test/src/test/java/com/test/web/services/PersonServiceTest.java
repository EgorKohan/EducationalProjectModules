package com.test.web.services;

import com.test.web.repository.SuperPerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService<SuperPerson, String> personService;

    @Test
    void test() {
        List<SuperPerson> all = personService.findAll();
        System.out.println("All");
    }

}
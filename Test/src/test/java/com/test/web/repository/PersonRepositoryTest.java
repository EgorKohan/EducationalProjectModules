package com.test.web.repository;

import com.test.web.SpringApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

//@SpringBootTest
//@ContextConfiguration(classes = SpringApp.class)
//class PersonRepositoryTest {
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Test
//    void test() {
//        SuperPerson superPerson = new SuperPerson("123", "Egor");
//        UsualPerson usualPerson = new UsualPerson("234", "Dima");
//
//        personRepository.save(superPerson);
//        personRepository.save(usualPerson);
//
//        List<Person> all = personRepository.findAll();
////        List<Person> allSuperPersons = personRepository.findAllSuperPersons();
////        List<Person> allUsualPersons = personRepository.findAllUsualPersons();
////        List<Person> allByClassPath = personRepository.findAllByClassPath(SuperPerson.class.getName());
//
//        System.out.println("The end");
//
//    }
//
//}
package com.test.web.threads;

import com.test.web.repository.SuperPerson;
import com.test.web.services.PersonService;
import lombok.SneakyThrows;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Thread1Test extends AbstractTest {

    @Autowired
    private ThreadBean threadBean;

    @MockBean
    @Autowired
    private PersonService<SuperPerson, String> personService;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterAll
    void clear() {

    }

    @SneakyThrows
    @Test
    void test1() {
        System.out.println("Test1");
        threadBean.startThread();
        List<SuperPerson> all = personService.findAll();
        Thread.sleep(5000);
        MatcherAssert.assertThat(all, Matchers.empty());
    }


    @SneakyThrows
    @Test
    void test2() {
        System.out.println("Test2");
        threadBean.startThread();
        List<SuperPerson> all = personService.findAll();
        Thread.sleep(5000);
        MatcherAssert.assertThat(all, Matchers.empty());
    }

}

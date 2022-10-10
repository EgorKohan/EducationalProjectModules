package com.habr.rus.services.impl;

import com.habr.rus.AbstractTest;
import com.habr.rus.models.User;
import com.habr.rus.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Slf4j
class UserServiceImplTest extends AbstractTest {

    @Autowired
    private UserService userService;

    @Test
    void get() {
        User user1 = userService.create(new User("Vasya", "vasya@mail.ru"));
        User user2 = userService.create(new User("Kolya", "kolya@mail.ru"));

        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
    }

    private void getAndPrint(Long id) {
        log.info("user found: {}", userService.getById(id));
    }

    @Test
    void create() {
        createAndPrint("Ivan", "ivan@mail.ru");
        createAndPrint("Ivan", "ivan122@mail.ru");
        createAndPrint("Sergey", "ivan@mail.ru");

        log.info("All entries are below: ");
        userService.getAll().forEach(System.out::println);

    }

    private void createAndPrint(String name, String email) {
        log.info("Created user: {}", userService.create(name, email));
    }

    @Test
    void createAndRefresh() {
        User user1 = userService.createOrReturnCached(new User("Vasya", "vasya@mail.ru"));
        log.info("Created user1: {}", user1);

        User user2 = userService.createOrReturnCached(new User("Vasya", "misha@mail.ru"));
        log.info("Created user2: {}", user2);

        User user3 = userService.createOrRefreshCached(new User("Vasya", "kolya@mail.ru"));
        log.info("Created user3: {}", user3);

        User user4 = userService.createOrReturnCached(new User("Vasya", "nikita@mail.ru"));
        log.info("Created user4: {}", user4);

    }

    @Test
    void delete(){
        User user1 = userService.create(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.getById(user1.getId()));

        User user2 = userService.create(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.getById(user2.getId()));

        userService.delete(user1.getId());
        userService.deleteAndEvict(user2.getId());

        log.info("{}", userService.getById(user1.getId()));
        log.info("{}", userService.getById(user2.getId()));
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void cacheManagerTest(){
        applicationContext.getBean("cacheManager");
    }

    @Test
    void checkSettings() throws InterruptedException {
        User user1 = userService.createOrReturnCached(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.getById(user1.getId()));

        User user2 = userService.createOrReturnCached(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.getById(user2.getId()));

        Thread.sleep(1000L);
        User user3 = userService.createOrReturnCached(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.getById(user3.getId()));
    }

}
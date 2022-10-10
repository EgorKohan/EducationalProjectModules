package ru.javarush;

import lombok.extern.slf4j.Slf4j;
import ru.javarush.models.User;
import ru.javarush.services.UserService;

@Slf4j
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User byId = userService.findById(1L);
        log.info("asassa: {}", byId.getAutos());
    }
}

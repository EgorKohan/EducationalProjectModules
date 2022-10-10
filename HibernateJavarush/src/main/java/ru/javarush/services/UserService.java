package ru.javarush.services;

import lombok.extern.slf4j.Slf4j;
import ru.javarush.daos.UserDao;
import ru.javarush.hibernate.HibernateSessionFactoryUtil;
import ru.javarush.models.Auto;
import ru.javarush.models.User;

import java.util.List;

@Slf4j
public class UserService {

    private final UserDao userDao = new UserDao();

    public User findById(Long id) {
        User byId = userDao.findById(id);
        log.info("User: {}", byId.getAutos());
        return byId;
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public Auto findAutoById(int id) {
        return userDao.findAutoById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

}

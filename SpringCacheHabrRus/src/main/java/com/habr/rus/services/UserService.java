package com.habr.rus.services;

import com.habr.rus.models.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User getById(Long id);

    User create(String name, String email);

    List<User> getAll();

    User createOrReturnCached(User user);

    User createOrRefreshCached(User user);

    void delete(Long id);

    void deleteAndEvict(Long id);

    void cacheExample(User user);

}

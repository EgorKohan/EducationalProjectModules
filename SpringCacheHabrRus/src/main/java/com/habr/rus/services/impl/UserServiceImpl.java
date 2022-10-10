package com.habr.rus.services.impl;

import com.habr.rus.models.User;
import com.habr.rus.repositories.UserRepository;
import com.habr.rus.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Cacheable(value = "users")
    public User getById(Long id) {
        log.info("Getting user with id {}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Cacheable(value = "users", key = "#name")
    public User create(String name, String email) {
        log.info("Creating user with name {}", name);
        return userRepository.save(new User(name, email));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "users", key = "#user.name")
    public User createOrReturnCached(User user) {
        log.info("creating user: {}", user);
        return userRepository.save(user);
    }

    @Override
    @CachePut(value = "users", key = "#user.name")
    public User createOrRefreshCached(User user) {
        log.info("creating user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        log.info("deleting user wit id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    @CacheEvict(value = "users")
    public void deleteAndEvict(Long id) {
        log.info("deleting user wit id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable("users"),
                    @Cacheable("tables"),
                    @Cacheable(value = "chairs", key = "#user.name")
            },
            put = {
                    @CachePut("armchairs"),
                    @CachePut("meals")
            },
            evict = {
                    @CacheEvict(value = "services", key = "#user.name")
            }
    )
    public void cacheExample(User user) {

    }
}

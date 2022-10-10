package com.test.web.repository;

import java.util.List;

public interface PersonRepository<T, ID> {

    List<T> findAll();

    T save(T t);

}

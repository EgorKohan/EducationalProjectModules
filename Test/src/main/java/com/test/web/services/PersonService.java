package com.test.web.services;

import com.test.web.repository.Person;
import com.test.web.repository.PersonRepository;
import com.test.web.repository.SuperPerson;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PersonService<T, K> {

    private final PersonRepository<T, K> personRepository;

    public PersonService(PersonRepository<T, K> personRepository) {
        this.personRepository = personRepository;
    }

    public List<T> findAll() {
        return personRepository.findAll();
    }

}

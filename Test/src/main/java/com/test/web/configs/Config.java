package com.test.web.configs;

import com.test.web.repository.SuperPerson;
import com.test.web.repository.SuperPersonRepository;
import com.test.web.services.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PersonService<SuperPerson, String> personServiceImpl(SuperPersonRepository superPersonRepository) {
        return new PersonService<>(superPersonRepository);
    }

}

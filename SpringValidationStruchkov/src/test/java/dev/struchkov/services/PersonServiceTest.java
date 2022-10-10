package dev.struchkov.services;

import dev.struchkov.AbstractTest;
import dev.struchkov.dtos.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;

class PersonServiceTest extends AbstractTest {

    @Autowired
    private PersonService personService;

    private static PersonDto createInvalidPersonDto() {
        return PersonDto.builder()
                .name("Egor")
                .numberBetweenOneAndTen(14)
                .ipAddress("asdasd")
                .build();
    }

    @Test
    void test() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> personService.save(createInvalidPersonDto()));
    }
}
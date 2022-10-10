package dev.struchkov.services;

import dev.struchkov.dtos.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

class ProgrammaticallyValidatingServiceTest {

    private final ProgrammaticallyValidatingService programmaticallyValidatingService
            = new ProgrammaticallyValidatingService();


    private static PersonDto createInvalidPersonDto() {
        return PersonDto.builder()
                .name("Egor")
                .numberBetweenOneAndTen(14)
                .ipAddress("asdasd")
                .build();
    }

    @Test
    void test() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            programmaticallyValidatingService.validateInput(createInvalidPersonDto());
        });
    }

}
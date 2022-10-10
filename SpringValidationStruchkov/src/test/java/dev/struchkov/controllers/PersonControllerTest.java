package dev.struchkov.controllers;

import dev.struchkov.AbstractTest;
import dev.struchkov.dtos.PersonDto;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

class PersonControllerTest extends AbstractTest {

    private static PersonDto createInvalidPersonDto() {
        return PersonDto.builder()
                .name("Egor")
                .numberBetweenOneAndTen(14)
                .ipAddress("asdasd")
                .build();
    }

    @Test
    void whenSendInvalidPerson_thenError() {
        given()
                .contentType("application/json")
                .accept("application/json")
                .with()
                .body(createInvalidPersonDto())
                .when()
                .post("/person")
                .then()
                .log().all()
                .assertThat().statusCode(400);
    }

    @Test
    void whenGetPersonWithInvalidId_thenError() {
        given()
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("/person/0")
                .then()
                .log().all()
                .assertThat().statusCode(400);
    }

}
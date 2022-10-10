package dev.struchkov.controllers;

import dev.struchkov.AbstractTest;
import dev.struchkov.dtos.PersonDto2;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class Person2ControllerTest extends AbstractTest {

    @Test
    void whenSendId_thenFail() {
        given()
                .contentType("application/json")
                .accept("application/json")
                .with()
                .body(new PersonDto2(150L, "abc"))
                .when()
                .post("/person2")
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .and()
                .assertThat().body("violations[0].fieldName", containsString("create.personDto2.id"));
    }

    @Test
    void whenSendLowerCaseName_thenFail() {
        given()
                .contentType("application/json")
                .accept("application/json")
                .with()
                .body(new PersonDto2(null, "abc"))
                .when()
                .post("/person2")
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .and()
                .assertThat().body("violations[0].message", containsString("invalid"));
    }

}
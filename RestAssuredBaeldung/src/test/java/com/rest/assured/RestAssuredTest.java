package com.rest.assured;

import com.rest.assured.models.OddModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RestAssuredTest {

    @Value("${server.port}")
    private Integer serverPort;

    @BeforeAll
    void setup() {
        port = serverPort;
    }

    @AfterAll
    void cleanup() {
        RestAssured.reset();
    }

    @Test
    void givenUrl_whenSuccessOnGetsResponseAndJsonHasRequiredKV_thenSuccess() {
        get("/events?id=390")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data.leagueId", equalTo(35));
    }

    @Test
    void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenSuccess() {
        get("/events?id=390")
                .then()
                .statusCode(200)
                .assertThat()
                .body("odds.price", hasItems(1.30f, 5.25f));
    }

    @Test
    void givenUrl_whenJsonResponseHasAnonymousArray123_thenSuccess() {
        get("/events/anonymous")
                .then()
                .statusCode(200)
                .assertThat()
                .body("$", hasItems(1, 2, 3))
                .and()
                .body("", hasItems(1, 2, 3));
    }

    @Test
    void whenRequestGet_thenOK() {
        when()
                .request("GET", "/events/anonymous").then().statusCode(200);

    }

    @Test
    void whenRequestPost_thenOK() {
        given()
                .contentType("application/json")
                .with()
                .body(new OddModel(new OddModel.Data(1L, "haha", "hehe"), List.of(new OddModel.Odd(15.5f, "price"))))
                .when()
                .request("POST", "/events/new")
                .then()
                .statusCode(201);
    }

    @Test
    void whenMeasureResponseTime_thenOK() {
        Response response = get("/events?id=390");
        long time = response.getTime();
        assertThat(time, lessThan(3000L));
    }

    @Test
    void whenValidateResponseTimeWithTime_thenOK() {
        get("/events?id=390")
                .then()
                .time(lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    void givenMethod_whenLogRequest_thenOK() {
        given()
                .contentType("application/json")
                .log().all()
                .get("/events?id=390")
                .then()
                .log().body()
                .and()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void whenUsePathParam_thenOK() {
        given()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("id", 390)
                .when().get("/events/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(390));
    }

    @Test
    void whenUsePathParams_thenOK() {
        given()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .pathParams("id", 390, "events", "events")
                .when().get("/{events}/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(390));
    }

    @Test
    void whenUserQueryRequest_thenOK() {
        given()
                .queryParam("id", 390)
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("/events")
                .then()
                .body("id", is(390));
    }

    /**
     * Finally, we can specify form parameters using formParam():
     *
     * @Test public void whenUseFormParam_thenSuccess() {
     * <p>
     * given().formParams("username", "john","password","1234").post("/");
     * <p>
     * given().params("username", "john","password","1234").post("/");
     * }
     * The param() method will act life formParam() for POST requests.
     * <p>
     * Also note that formParam() adds a Content-Type header with the value “application/x-www-form-urlencoded“.
     */

    @Test
    void whenUserCustomHeader_thenOK() {
        given()
                .header("User-Agent", "MyAppName")
                .when()
                .get("/events?id=390")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void whenUserCustomHeaders_thenOK() {
        given()
                .header("X-Custom-Header", "MyAppName", "RandomValue")
                .log().headers()
                .when()
                .get("/events?id=390")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void whenUserCookie_thenOK() {
        given()
                .cookie("session_id", "1234")
                .log().cookies()
                .when().get("/events?id=390")
                .then()
                .log().cookies()
                .assertThat().statusCode(200);
    }

}

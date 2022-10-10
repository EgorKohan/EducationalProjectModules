package com.rest.assured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.assured.models.OddModel;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObjectMapperTest {

    String json = "{\n" +
            "    \"id\": \"390\",\n" +
            "    \"data\": {\n" +
            "        \"leagueId\": 35,\n" +
            "        \"homeTeam\": \"Norway\",\n" +
            "        \"visitingTeam\": \"England\"\n" +
            "    },\n" +
            "    \"odds\": [{\n" +
            "        \"price\": \"1.30\",\n" +
            "        \"name\": \"1\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"price\": \"5.25\",\n" +
            "        \"name\": \"X\"\n" +
            "    }]\n" +
            "}";

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void givenMapper_whenParseString_thenSuccess() throws JsonProcessingException {
        OddModel oddModel = objectMapper.readValue(json, OddModel.class);
        MatcherAssert.assertThat(oddModel, Matchers.notNullValue());
    }

}

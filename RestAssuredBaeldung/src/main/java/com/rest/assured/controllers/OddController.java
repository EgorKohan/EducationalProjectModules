package com.rest.assured.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.assured.models.OddModel;
import org.apache.groovy.util.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class OddController {

    List<OddModel> oddModelList = new ArrayList<>();

    Map<Long, String> map = Maps.of(390L,
            "{\n" +
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
                    "}");

    @GetMapping
    public OddModel getOddInfo(@RequestParam("id") Long id) throws JsonProcessingException {
        return new ObjectMapper().readValue(map.get(id), OddModel.class);
    }

    @GetMapping(value = "/anonymous", produces = "application/json")
    public String getAnonymousJson() {
        return "[1, 2, 3]";
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> createNewOdd(@RequestBody OddModel oddModel) {
        oddModelList.add(oddModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public OddModel getModelWithPathId(@PathVariable Long id) throws JsonProcessingException {
        return new ObjectMapper().readValue(map.get(id), OddModel.class);
    }

}

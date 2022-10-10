package com.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person = new GigaChad();

        String s = Optional.ofNullable(getMap())
                .filter(body -> body.containsKey("aboba"))
                .map(body -> (String) body.get("id"))
                .orElseThrow(() -> {
                    throw new RestClientException("asd");
                });

        System.out.println(s);

    }

    public String createSubscriptionInMist(String url, String mistId) {
        ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return Optional.ofNullable(responseEntity.getBody())
                .filter(body -> responseEntity.getStatusCode().is2xxSuccessful())
                .map(body -> (String) body.get("id"))
                .orElseThrow(() -> {
                    throw new RestClientException("Exception during request to mist: response body is null. Response code: " + responseEntity.getStatusCode());
                });
    }

    private static Map<String, Object> getMap() {
        return new HashMap<String, Object>() {
            {
                put("id", "asd");
            }
        };
    }

}

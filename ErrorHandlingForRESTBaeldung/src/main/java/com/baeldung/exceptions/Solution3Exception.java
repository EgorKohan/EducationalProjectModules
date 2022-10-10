package com.baeldung.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;

@ResponseStatus(TOO_MANY_REQUESTS)
public class Solution3Exception extends RuntimeException{

    public Solution3Exception(String message) {
        super(message);
    }

}

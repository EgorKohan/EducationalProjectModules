package com.baeldung.advices;

import com.baeldung.exceptions.Solution3Exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Solution3Exception.class})
    public ResponseEntity<Object> onSolution3Exception(Solution3Exception e, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(), HttpStatus.INSUFFICIENT_STORAGE, request);
    }

}

package com.baeldung.controllers;

import com.baeldung.exceptions.CustomException;
import com.baeldung.exceptions.CustomResponseStatusException;
import com.baeldung.exceptions.Solution3Exception;
import com.baeldung.services.FooService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * This approach has a major drawback: The @ExceptionHandler annotated method
 * is only active for that particular Controller,
 * not globally for the entire application. Of course, adding this to every
 * controller makes it not well suited for a general exception handling mechanism.
 * <p>
 * We can work around this limitation by having all Controllers extend a Base Controller class.
 */

@RestController
public class FooController {

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<?> handleException() {
        System.out.println("Handled");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/someMethod")
    public String someMethod() {
        return fooService.returnString();
    }

    @GetMapping("/someMethod2")
    public String someMethod2() {
        throw new CustomResponseStatusException();
    }

    @GetMapping("/someMethod3")
    public String someMethod3() {
        throw new IllegalArgumentException("Exception");
    }

    @GetMapping("/someMethod4")
    public String someMethod4() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Some Method 4 not found");
    }

    @GetMapping("/someMethod5")
    public String someMethod5() {
        throw new Solution3Exception("Aboba");
    }

}

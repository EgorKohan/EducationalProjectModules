package com.baeldung.services;

import com.baeldung.exceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    public String returnString(){
        throw new CustomException("Foo exception");
    }

}

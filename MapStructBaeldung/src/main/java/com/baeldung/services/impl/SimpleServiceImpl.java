package com.baeldung.services.impl;

import com.baeldung.services.SimpleService;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Override
    public String enrichName(String name) {
        return name + " (enriched)";
    }

}

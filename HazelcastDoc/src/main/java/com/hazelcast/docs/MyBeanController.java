package com.hazelcast.docs;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBeanController {

    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public MyBeanController(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @GetMapping
    public void get(){
        hazelcastInstance.getMap("MyMap").put("Kyky", "Kaka");
    }

}

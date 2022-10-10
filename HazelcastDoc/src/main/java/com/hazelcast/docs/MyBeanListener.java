package com.hazelcast.docs;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.listener.EntryAddedListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBeanListener implements EntryAddedListener<String, String> {

    private final HazelcastInstance hazelcastInstance;

    @Autowired
    public MyBeanListener(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @PostConstruct
    public void init(){
        hazelcastInstance.getMap("MyMap").addEntryListener(this, true);
    }

    @Override
    public void entryAdded(EntryEvent<String, String> event) {
        System.out.println("Added");
    }



}

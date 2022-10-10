package com.test.web.threads;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.Executors;

@Component
public class ThreadBean {

    private final HazelcastInstance hazelcast;

    @Autowired
    public ThreadBean(@Qualifier("hazelcastInstance") HazelcastInstance hazelcast) {
        this.hazelcast = hazelcast;
    }

    @SneakyThrows
    public void startThread() {
        Executors.newSingleThreadExecutor().submit(() -> {
            while (true) {
                hazelcast.getMap("names").put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
                System.out.println("Thread: " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println(hazelcast.getMap("names"));
            }
        });
    }

}

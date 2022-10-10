package com.baeldung;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.TestInstance;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Test {

    private static final Long SLEEP_INTERVAL = 5000L;

    private static List<String> createDynamicList(/*FluxSink<String> fluxSink*/) {
        List<String> list = new ArrayList<>();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                fluxSink.next(LocalTime.now().toString());
                list.add(LocalTime.now().toString());
                sleep(SLEEP_INTERVAL);
            }
        }).start();
        return list;
    }

    @org.junit.jupiter.api.Test
    void test1() {
        Flux.fromIterable(createDynamicList())
                .subscribe(
                        event -> log.info("Event - {}", event)
                );
        sleep(SLEEP_INTERVAL * 1000);
    }

    private static void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {
        }
    }

}

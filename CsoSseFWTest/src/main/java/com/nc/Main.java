package com.nc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new LinkedList<>();
        ParameterizedTypeReference<Map<Object, Object>> type = new ParameterizedTypeReference<>() {
        };
        WebClient webClient = WebClient.create("https://eu.cso.juniper.net");
        Flux<Map<Object, Object>> mapFlux = webClient.get()
                .uri("/streams/csp?filter=job-service:job")
                .header("X-Auth-Token",
                        "gAAAAABixDNuHGr0aKPLXR4Tz79Ejsgfou0W3fctRsVoEov0ZadKOSh2gTOsYT1BhjaFtvHrHPgljaHR_947v-N7rfkSquIUjp-U9p5WRKc80ipGVz0BhIHzTUVK2tnkUToihMbCdtejscmukcYJsfZgs2Pp5gnXVEO3jLOzPEpqc4KCzUX-IhBGhUxW7zaMJJEDKEszC8-C"
                )
                .retrieve()
                .bodyToFlux(type);

        mapFlux
                .log()
                .retry()
                .doOnSubscribe(subscription -> log.info("Do on subscribe! Subscription : {}", subscription))
                .doOnComplete(() -> log.info("Do on complete!"))
                .doOnTerminate(() -> log.info("Do on terminate!"))
                .doOnError(throwable -> log.error("Do on error! Error: ", throwable))
                .doOnCancel(() -> log.info("Flux is cancelled!"))
                .subscribe(
                        content -> {
                            log.info("Event: {}", content);
                            list.add(content);
                        },
                        error -> log.error("Error: ", error),
                        () -> log.info("The channel is closed")
                );

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("Count of events: {}", list.size());
        }, 0, 10, TimeUnit.SECONDS);

        Thread.sleep(1000000000000000000L);

    }

}

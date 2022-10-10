package com.baeldung;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SseControllerTest {

    @SneakyThrows
    @Test
    void givenSseChannel_whenCloseAndReopen_thenOK() {
        ParameterizedTypeReference<ServerSentEvent<String>> type = new ParameterizedTypeReference<>() {
        };
        WebClient webClient = WebClient.create("http://localhost:8080");
        Flux<ServerSentEvent<String>> flux = webClient.get()
                .uri("/stream-sse")
                .retrieve()
                .bodyToFlux(type);

        Disposable subscription1 = flux
                .doOnSubscribe(
                        subscription -> log.info("Subscribed! Subscription: {}", subscription)
                )
                .log()
                .subscribe(
                        content -> log.info("Content: {}", content),
                        error -> log.error("Error: ", error),
                        () -> log.info("Completion of a channel!")
                );

        Thread.sleep(3 * 5000);
        if (!subscription1.isDisposed()) subscription1.dispose();
    }

}

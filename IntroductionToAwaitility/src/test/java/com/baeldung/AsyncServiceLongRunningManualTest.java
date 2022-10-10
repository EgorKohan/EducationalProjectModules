package com.baeldung;

import org.awaitility.Awaitility;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class AsyncServiceLongRunningManualTest {

    private AsyncService asyncService;

    @BeforeEach
    void setUpBeforeEach() {
        asyncService = new AsyncService();
    }

    @Test
    void testDuration() {
        asyncService.initialize();
        Awaitility
                .given()
                .atLeast(100, TimeUnit.MILLISECONDS)
                .atMost(5, TimeUnit.SECONDS)
                .with()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .await()
                .until(asyncService::isInitialized);
    }

    @Test
    void whenWaitUntilInitialized_thenOK() {
        asyncService.initialize();
        Awaitility.await()
                .until(asyncService::isInitialized);
        MatcherAssert.assertThat(asyncService.isInitialized(), is(true));
    }

    @Test
    void whenChangeValue_thenOK() {
        asyncService.initialize();
        Awaitility.await()
                .until(asyncService::isInitialized);
        long value = 5;
        asyncService.addValue(value);
        Awaitility.await().until(asyncService::getValue, is(value));
    }

    @Test
    void whenChangeValueWOInitialize_thenOK() {
        asyncService.initialize();
        Awaitility.given().ignoreException(IllegalStateException.class)
                .await().atMost(5, TimeUnit.SECONDS)
                .atLeast(100, TimeUnit.MILLISECONDS)
                .until(asyncService::getValue, equalTo(0L));
    }

    @Test
    void testWithProxy() {
        asyncService.initialize();
//        Awaitility.await()
//                .until(AwaitilityClassProxy.to(asyncService).isInitialized(), equalTo(true));
        // Doent's work untilCall
    }

    @Test
    void testWithReflection() {
        asyncService.initialize();
        Awaitility.await()
                .until(
                        Awaitility.fieldIn(asyncService)
                                .ofType(boolean.class)
                                .andWithName("initialized"),
                        equalTo(true)
                );
    }

}

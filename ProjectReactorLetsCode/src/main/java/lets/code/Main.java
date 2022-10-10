package lets.code;

import lombok.SneakyThrows;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        Mono.empty();
//        Flux.empty();
//
//        Mono<Integer> mono = Mono.just(1);
//        Flux<Integer> flux = Flux.just(1, 2, 3);
//
//        Flux<Integer> fluxFromMono = mono.flux();
//        Mono<Boolean> monoFromFlux = flux.any(s -> s.equals(1)); //?????????
//        Mono<Integer> integerMono = flux.elementAt(1);

//        Flux.range(1, 5).subscribe(
//                System.out::println
//        );
//        Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))
//                .subscribe(System.out::println);

//        Flux
//                .<String>generate(
//                        sink -> {
//                            sink.next("Hello1");
//                        }
//                )
//                .delayElements(Duration.ofSeconds(1))
//                .take(4)
//                .subscribe(System.out::println);

//        Flux
//                .<String>generate(
//                        sink -> {
//                            sink.next("Hello2");
//                        }
//                )
//                .delayElements(Duration.ofSeconds(1))
//                .take(4)
//                .subscribe(System.out::println);
//
//        Thread.sleep(2000);

//        Flux<Object> telegramProducer = Flux.generate(
//                () -> 2354,
//                (state, sink) -> {
//                    if (state > 2366) {
//                        sink.complete();
//                    } else sink.next("Step: " + state);
//                    return state + 3;
//                }
//        );

//        Flux.create(
//                sink -> telegramProducer.subscribe(new BaseSubscriber<>() {
//                    @Override
//                    protected void hookOnNext(Object value) {
//                        sink.next(value);
//                    }
//
//                    @Override
//                    protected void hookOnComplete() {
//                        sink.complete();
//                    }
//                })
//        );

//        Flux.create(
//                sink -> {
//                    telegramProducer.subscribe(new BaseSubscriber<>() {
//                    @Override
//                    protected void hookOnNext(Object value) {
//                        sink.next(value);
//                    }
//
//                    @Override
//                    protected void hookOnComplete() {
//                        sink.complete();
//                    }
//                });
//                    sink.onRequest(r -> {
//                        sink.next("DB returns " + telegramProducer.blockFirst());
//                    });
//                }
//        ).subscribe(System.out::println);
//
//        Flux<String> flux1 = Flux.just("World", "coder").repeat();
//
//        Flux<String> flux2 = Flux.just("hello", "dru", "java", "Linus", "Asia", "java")
//                .zipWith(flux1, (f, s) -> String.format("%s %s", f, s));
//
//        Flux<String> takeFlux = flux2
//                .delayElements(Duration.ofMillis(1500))
//                .timeout(Duration.ofSeconds(1))
////                .retry(3)
//                .onErrorResume(throwable -> {
//                    return Flux.interval(Duration.ofMillis(300))
//                            .map(String::valueOf);
//                })
//                .skip(2)
//                .take(3);
//
//        takeFlux.subscribe(
//                v -> System.out.println(v),
//                e -> System.out.println(e),
//                () -> System.out.println("The end")
//        );
//
//        Thread.sleep(5000);

        Disposable subscribe = Flux.create(fluxSink -> {
                    for (int i = 0; i < 1000; i++) {
                        fluxSink.next(i);
                    }
                }).delayElements(Duration.ofSeconds(1))
                .doOnSubscribe(subscription -> System.out.println("Step1"))
                .doOnSubscribe(subscription -> System.out.println("Step2"))
                .subscribe();

    }

}

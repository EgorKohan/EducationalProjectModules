package my.test;

import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ArrayMatches<T> extends TypeSafeMatcher<T[]> {

    private final T[] items;

    public ArrayMatches(T[] items) {
        this.items = items;
    }

    @Override
    protected boolean matchesSafely(T[] itemsToMatch) {
        List<T> list = Arrays.stream(itemsToMatch).collect(Collectors.toList());
        return Arrays.stream(items).allMatch(item -> {
            System.out.println(item);
            return list.contains(item);
        });
    }

    public static <T> Matcher<T[]> arrayMatches(T... items) {
        return new ArrayMatches<T>(items);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Doesn't contains blabla");
    }
}

class URITest {

    @Test
    void testURI() {
        LocalDateTime localDateTime = LocalDateTime.now().plus(10000, ChronoUnit.MILLIS);
        LocalDateTime localDateTime2 = LocalDateTime.now().plus(100000, ChronoUnit.MILLIS);
        assert localDateTime.isBefore(localDateTime2);
    }

    @Test
    void jsonNodeTest() {
        String str = "{\n" +
                "    \"job\": [],\n" +
                "    \"total\": 0\n" +
                "}";
        String read = JsonPath.parse(str).read("$.job[0].status");
        System.out.println(read);
    }

    @SneakyThrows
    @Test
    void test3() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        ScheduledFuture<?> hello = scheduledExecutorService.scheduleAtFixedRate(this::doSmth, 0, 10, TimeUnit.SECONDS);

        execute(this::doSmth, 2, 10);

        Thread.sleep(2000000000);
    }

    private void execute(Consumer<CompletableFuture<Object>> consumer, long period, long duration) {
        CompletableFuture<Object> completableFuture = new CompletableFuture<>();
        ScheduledFuture<?> fixedRate = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> consumer.accept(completableFuture), 0, period, TimeUnit.SECONDS);

        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            if (!fixedRate.isCancelled()) {
                System.out.println("Cancelling of scheduled job!");
                fixedRate.cancel(true);
            }
        }, duration, TimeUnit.SECONDS);

        completableFuture.thenAccept(o -> {
            System.out.println("Result " + o);
            if (!fixedRate.isCancelled()) {
                fixedRate.cancel(true);
            }
        });
    }


    int a = 0;

    private void doSmth(CompletableFuture<Object> completableFuture) {
        if (a != 3) {
            System.out.println("Barabarabara");
            a++;
        } else {
            System.out.println("Bereberebere");
            completableFuture.complete(a);
        }
    }

    private Integer[] eratosthenes(int n) {
        int[] array = IntStream.range(0, n + 1).toArray();
        System.out.println(Arrays.toString(array));
        List<Integer> list = new ArrayList<>(Collections.singletonList(1));
        array[1] = 0;
        int i = 2;
        while (i <= n) {
            if (array[i] != 0) {
                System.out.println(array[i]);
                list.add(array[i]);
                int j = i + i;
                while (j <= n) {
                    array[j] = 0;
                    j = j + i;
                }
            }
            i++;
        }
        return list.stream().filter(num -> num != 0).toArray(Integer[]::new);
    }

    @Test
    void eratosthenesTest() {
        Integer[] arr = eratosthenes(20);
        MatcherAssert.assertThat(arr, ArrayMatches.arrayMatches(2, 3, 5));
    }

    @Test
    void testStringHashCode() {
        String a = "a";
        String bcd = "bcd";
        System.out.println((int) a.charAt(0));
        System.out.println(a.hashCode());
        System.out.println(bcd.hashCode());
    }

}

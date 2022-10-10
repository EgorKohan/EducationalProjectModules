package com.baeldung;

import lombok.NonNull;
import org.checkerframework.checker.initialization.qual.Initialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@ApplicationScoped
public class StockService {

    private static final BigDecimal UP = BigDecimal.valueOf(1.05f);
    private static final BigDecimal DOWN = BigDecimal.valueOf(0.95f);

    private List<String> stockNames = Arrays.asList("GOOG", "IBM", "MS", "GOOG", "YAHOO");
    private List<Stock> stocksDb = new ArrayList<>();

    private final AtomicInteger counter = new AtomicInteger(0);

//    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
//        System.out.println("@Start init...");
//        stockNames.forEach(stockName -> {
//            stocksDb.add(new Stock(counter.incrementAndGet(), stockName, generateOpenPrice(), LocalDateTime.now()));
//        });
//
//        Runnable runnable = () -> {
//          while (true) {
//              int index = new Random().nextInt(stockNames.size());
//              String stockName = stockNames.get(index);
//              BigDecimal price = getLastPrice(stockName);
//              BigDecimal newPrice = changePrice(price);
//              Stock stock = new Stock(counter.incrementAndGet(), stockName, newPrice, LocalDateTime.now());
//              stocksDb.add(stock);
//
//              int r = new Random().nextInt(30);
//              try{
//                  Thread.sleep(r * 1000);
//              } catch (InterruptedException ignored) {
//              }
//          }
//        };
//        new Thread(runnable).start();
//        System.out.println("@End Init...");
//
//    }

    public Stock getNextTransaction(@NonNull Integer lastEventId) {
        return stocksDb.stream().filter(s -> s.getId().equals(lastEventId)).findFirst().orElse(null);
    }

    private BigDecimal generateOpenPrice() {
        final float min = 70;
        final float max = 120;
        return BigDecimal.valueOf(min + new Random().nextFloat() * (max - min)).setScale(4, RoundingMode.CEILING);
    }

    private BigDecimal changePrice(@NonNull BigDecimal price) {
        return Math.random() >= 0.5 ? price.multiply(UP).setScale(4, RoundingMode.CEILING) : price.multiply(DOWN).setScale(4, RoundingMode.CEILING);
    }

    private BigDecimal getLastPrice(String stockName) {
        return stocksDb.stream().filter(s -> s.getName().equals(stockName)).findFirst().get().getPrice();
    }

}

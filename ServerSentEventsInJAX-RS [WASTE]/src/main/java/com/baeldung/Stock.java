package com.baeldung;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Stock {

    private Integer id;
    private String name;
    private BigDecimal price;
    private LocalDateTime dateTime;

}

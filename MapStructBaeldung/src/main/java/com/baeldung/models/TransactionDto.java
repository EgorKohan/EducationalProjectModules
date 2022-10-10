package com.baeldung.models;

import lombok.Data;

@Data
public class TransactionDto {

    private String uuid;

    private Long totalInCents;

}

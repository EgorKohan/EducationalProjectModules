package com.baeldung.mappers;

import com.baeldung.models.Transaction;
import com.baeldung.models.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public abstract class TransactionMapper {

    public abstract Transaction toTransaction(TransactionDto transactionDto);

    public TransactionDto toTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setUuid(transaction.getUuid());
        transactionDto.setTotalInCents(transaction.getTotal().multiply(new BigDecimal("100")).longValue());
        return transactionDto;
    }

    public abstract List<TransactionDto> toTransactionDtos(List<Transaction> transactions);

}

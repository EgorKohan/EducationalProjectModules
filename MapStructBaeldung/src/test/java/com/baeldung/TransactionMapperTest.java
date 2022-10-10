package com.baeldung;

import com.baeldung.mappers.TransactionMapper;
import com.baeldung.models.Transaction;
import com.baeldung.models.TransactionDto;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;

class TransactionMapperTest {

    private final TransactionMapper transactionMapper = Mappers.getMapper(TransactionMapper.class);

    @Test
    void test() {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setTotal(new BigDecimal(5));

        TransactionDto transactionDto = transactionMapper.toTransactionDto(transaction);
        MatcherAssert.assertThat(transaction.getTotal().longValue(), is(transactionDto.getTotalInCents() / 100));
    }

}

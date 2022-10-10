package patterns.strategy;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class CreditCard {
    private int amount = 100_000;
    @Setter(value = AccessLevel.NONE)
    private final String number;
    @Setter(value = AccessLevel.NONE)
    private final String date;
    @Setter(value = AccessLevel.NONE)
    private final String cvv;
}
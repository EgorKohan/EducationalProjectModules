package mockito;

import com.test.mockito.DigitSummer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MockitoStubbingInBeforeAll {

    @Mock
    private static DigitSummer digitSummer;

    @BeforeAll
    static void setUp() {
        Mockito.when(digitSummer.sum(Mockito.anyInt(), Mockito.anyInt())).thenReturn(10);
    }

    @Order(1)
    @Test
    void test1() {
        digitSummer.sum(1, 2);
        Mockito.verify(digitSummer, Mockito.only()).sum(Mockito.anyInt(), Mockito.anyInt());
    }

    @Order(2)
    @Test
    void test2() {
        digitSummer.sum(1, 2);
        Mockito.verify(digitSummer, Mockito.times(2)).sum(Mockito.anyInt(), Mockito.anyInt());
    }

}

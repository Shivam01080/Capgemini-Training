package com.dk;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StepsToGetBackWithSumDigitSquaresTest {

    @ParameterizedTest
    @CsvSource({
        "19, -1",
        "7, -1",
        "1,1"
    })
    void testGetSteps(int input, int expected) {
        StepsToGetBackWithSumDigitSquares obj =
                new StepsToGetBackWithSumDigitSquares();

        assertEquals(expected, obj.getSteps(input));
    }
}
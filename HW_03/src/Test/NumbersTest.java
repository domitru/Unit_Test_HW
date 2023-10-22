package Test;

import One.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    public void createNumbersClass(){
        numbers = new Numbers();
    }

    @ParameterizedTest
    @ValueSource (ints = {3, 15, 98})
    void evenOddNumberCheckTrue(int number) {
        assertTrue(numbers.evenOddNumberCheck(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {3, 45, 106, 34})
    void evenOddNumberCheckFalse(int number) {
        assertFalse(numbers.evenOddNumberCheck(number));
    }
}

package Test;

import Two.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {
    private Two.Range range;

    @BeforeEach
    public void createClassRange(){
        range = new Range();
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 50 , 99})
    void numberInIntervalIsTrue(int number) {
        assertTrue(range.numberInInterval(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100, -1, 1000})
    void numberInIntervalIsFalse(int number) {
        assertFalse(range.numberInInterval(number));
    }
}

package Calculator;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        testCalculateDiscount();
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 6 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));
    }

    // START HW01
    // Проверить этот метод с использованием библиотеки AssertJ.
    // Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
    public static void testCalculateDiscount() {
        // Проверка, что метод выбрасывает исключение при недопустимых аргументах
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-1, 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incorrect discount amount");

        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incorrect discount amount");

        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, 101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incorrect discount amount");

        // Проверка, что метод возвращает правильную сумму покупки со скидкой
        assertThat(Calculator.calculatingDiscount(100, 10)).isEqualTo(90.0);
        assertThat(Calculator.calculatingDiscount(200, 20)).isEqualTo(160.0);
        assertThat(Calculator.calculatingDiscount(300, 50)).isEqualTo(150.0);
        // END HW01
    }
}

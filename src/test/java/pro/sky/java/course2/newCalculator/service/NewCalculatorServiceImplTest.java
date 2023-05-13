package pro.sky.java.course2.newCalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NewCalculatorServiceImplTest {

    private final NewCalculatorServiceImpl out = new NewCalculatorServiceImpl();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> out.calculate(4, "100", "0")
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNumberIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> out.calculate(4, "100", " ")
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNumberIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> out.calculate(4, "1OO", "4")          //  вместо  0  буква  О
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldReturnMessageWhenCalculate(
            int operator,
            String num1,
            String num2,
            String expectedMessage) {
        String result = out.calculate(operator, num1, num2);
        Assertions.assertTrue(result.contains(expectedMessage));
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(1, "10", "90", "10 + 90 = 100"),
                Arguments.of(1, "-100", "90", "-100 + 90 = -10"),
                Arguments.of(1, "-100", "-100", "-100 + -100 = -200"),
                Arguments.of(2, "100", "90", "100 - 90 = 10"),
                Arguments.of(2, "0", "90", "0 - 90 = -90"),
                Arguments.of(2, "-10", "-90", "-10 - -90 = 80"),
                Arguments.of(3, "0", "90", "0 * 90 = 0"),
                Arguments.of(3, "-5", "5", "-5 * 5 = -25"),
                Arguments.of(3, "-5", "-5", "-5 * -5 = 25"),
                Arguments.of(4, "5", "5", "5 / 5 = 1"),
                Arguments.of(4, "25", "5", "25 / 5 = 5"),
                Arguments.of(4, "-100", "4", "-100 / 4 = -25")
        );
    }
}

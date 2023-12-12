package games;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzTests {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    @ParameterizedTest
    @MethodSource("notMultipleOf3Nor5")
    void returns_the_given_number_for_non_multiple_of_3_nor_5(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i)).isEqualTo(String.valueOf(i));
    }

    @ParameterizedTest
    @MethodSource("onlyMultiplesOf3")
    void returns_Fizz_for_multiple_of_3(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i)).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @MethodSource("onlyMultiplesOf5")
    void returns_Buzz_for_multiple_of_5(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @MethodSource("multipleOf3And5")
    void returns_FizzBuzz_for_multiple_of_3_and_5(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i)).isEqualTo("FizzBuzz");
    }

    @Test
    void throws_an_exception_for_too_small_value() {
        assertThatThrownBy(() -> FizzBuzz.convert(MIN_VALUE - 1)).isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void throws_an_exception_for_too_big_value() {
        assertThatThrownBy(() -> FizzBuzz.convert(MAX_VALUE + 1)).isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void throws_an_exception_for_minus_1() {
        assertThatThrownBy(() -> FizzBuzz.convert(-1)).isInstanceOf(OutOfRangeException.class);
    }

    static IntStream notMultipleOf3Nor5() {
        return validRange().filter(not(multipleOf(3)).and(not(multipleOf(5))));
    }

    static IntStream onlyMultiplesOf3() {
        return validRange().filter(multipleOf(3).and(not(multipleOf(5))));
    }

    static IntStream onlyMultiplesOf5() {
        return validRange().filter(multipleOf(5).and(not(multipleOf(3))));
    }

    static IntStream multipleOf3And5() {
        return validRange().filter(multipleOf(3).and(multipleOf(5)));
    }

    @Contract(pure = true)
    private static @NotNull IntStream validRange() {
        return IntStream.range(MIN_VALUE, MAX_VALUE);
    }

    @Contract(pure = true)
    private static @NotNull IntPredicate multipleOf(Integer d) {
        return (i) -> i % d == 0;
    }

    @Contract(pure = true)
    private static @NotNull IntPredicate not(@NotNull IntPredicate p) {
        return p.negate();
    }
}
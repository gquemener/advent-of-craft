package games;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzTests {
    public static IntStream notMultipleOf3Nor5() {
        return IntStream
                .range(1, 100)
                .filter((i) -> i % 3 != 0) // TODO: replace with partial application of a multipleOf function
                .filter((i) -> i % 5 != 0);
    }

    public static IntStream onlyMultiplesOf3() {
        return IntStream
                .range(1, 100)
                .filter((i) -> i % 3 == 0) // TODO: replace with partial application of a multipleOf function
                .filter((i) -> i % 5 != 0);
    }

    public static IntStream onlyMultiplesOf5() {
        return IntStream
                .range(1, 100)
                .filter((i) -> i % 5 == 0) // TODO: replace with partial application of a multipleOf function
                .filter((i) -> i % 3 != 0);
    }

    public static IntStream multipleOf3And5() {
        return IntStream
                .range(1, 100)
                .filter((i) -> i % 5 == 0) // TODO: replace with partial application of a multipleOf function
                .filter((i) -> i % 3 == 0);
    }

    @ParameterizedTest
    @MethodSource("notMultipleOf3Nor5")
    void returns_the_given_number_for_non_multiple_of_3_nor_5(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i))
                .isEqualTo(String.valueOf(i));
    }

    @ParameterizedTest
    @MethodSource("onlyMultiplesOf3")
    void returns_Fizz_for_multiple_of_3(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i))
                .isEqualTo("Fizz");
    }

    @ParameterizedTest
    @MethodSource("onlyMultiplesOf5")
    void returns_Buzz_for_multiple_of_5(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i))
                .isEqualTo("Buzz");
    }

    @ParameterizedTest
    @MethodSource("multipleOf3And5")
    void returns_FizzBuzz_for_multiple_of_3_and_5(Integer i) throws OutOfRangeException {
        assertThat(FizzBuzz.convert(i))
                .isEqualTo("FizzBuzz");
    }

    @Test
    void throws_an_exception_for_0() {
        assertThatThrownBy(() -> FizzBuzz.convert(0))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void throws_an_exception_for_101() {
        assertThatThrownBy(() -> FizzBuzz.convert(101))
                .isInstanceOf(OutOfRangeException.class);
    }

    @Test
    void throws_an_exception_for_minus_1() {
        assertThatThrownBy(() -> FizzBuzz.convert(-1))
                .isInstanceOf(OutOfRangeException.class);
    }
}
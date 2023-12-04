package games.integer;

public class Factory {
    public static FizzBuzzInteger createFizzBuzzInteger(Integer input) {
        if (isMultipleOf(input, 3) && isMultipleOf(input, 5)) {
            return new games.integer.FizzBuzz();
        }
        if (isMultipleOf(input, 3)) {
            return new Fizz();
        }
        if (isMultipleOf(input, 5)) {
            return new Buzz();
        }

        return new Number(input);
    }

    private static boolean isMultipleOf(Integer input, int divisor) {
        return input % divisor == 0;
    }
}

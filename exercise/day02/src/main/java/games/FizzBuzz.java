package games;

import static games.integer.Factory.createFizzBuzzInteger;

public class FizzBuzz {

    private static final int MIN = 0;
    private static final int MAX = 100;

    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        if (isOutOfRange(input)) {
            throw new OutOfRangeException();
        }

        return createFizzBuzzInteger(input).asString();
    }

    private static boolean isOutOfRange(Integer input) {
        return input <= MIN || input > MAX;
    }
}

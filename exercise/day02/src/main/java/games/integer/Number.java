package games.integer;

public class Number implements FizzBuzzInteger {
    private final Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    @Override
    public String asString() {
        return value.toString();
    }
}

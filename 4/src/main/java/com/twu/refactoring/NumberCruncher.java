package com.twu.refactoring;

import java.util.Arrays;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return (int) Arrays.stream(numbers)
                .filter(value -> value % 2 == 0)
                .count();
    }

    public int countOdd() {
        return (int) Arrays.stream(numbers)
                .filter(value -> value % 2 == 1)
                .count();
    }

    public int countPositive() {
        return (int) Arrays.stream(numbers)
                .filter(value -> value >= 0)
                .count();
    }

    public int countNegative() {
        return (int) Arrays.stream(numbers)
                .filter(value -> value < 0)
                .count();
    }
}

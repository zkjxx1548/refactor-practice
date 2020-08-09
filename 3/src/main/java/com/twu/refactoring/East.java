package com.twu.refactoring;

import java.util.Objects;

public class East implements Direction {
    private final char direction = 'E';

    public East() {
    }

    @Override
    public Direction turnLeft() {
        return new North();
    }

    @Override
    public Direction turnRight() {
        return new South();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        East east = (East) o;
        return direction == east.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}

package com.twu.refactoring;

import java.util.Objects;

public class South implements Direction {
    private final char direction = 'S';

    public South() {
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        South south = (South) o;
        return direction == south.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}

package com.twu.refactoring;

import java.util.Objects;

public class North implements Direction {
    private final char direction = 'N';

    public North() {
    }

    @Override
    public Direction turnLeft() {
        return new West();
    }

    @Override
    public Direction turnRight() {
        return new East();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        North north = (North) o;
        return direction == north.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

}

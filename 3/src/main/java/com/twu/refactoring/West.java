package com.twu.refactoring;

public class West implements Direction {
    private char direction = 'W';

    public West() {
    }

    @Override
    public Direction turnLeft() {
        return new South();
    }

    @Override
    public Direction turnRight() {
        return new North();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        West west = (West) o;
        return direction == west.direction;
    }
}

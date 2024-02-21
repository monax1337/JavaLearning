package learn.organs.claws;

import learn.organs.Organs;

import java.util.Objects;

public class Claws extends Organs {
    private int length;

    public Claws(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claws claws = (Claws) o;
        return length == claws.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    public String toString() {
        return "Claws{" +
                "length=" + length +
                '}';
    }
}

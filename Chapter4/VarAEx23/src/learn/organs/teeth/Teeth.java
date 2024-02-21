package learn.organs.teeth;

import learn.organs.Organs;

import java.util.Objects;

public class Teeth extends Organs {
    private int sharpness;

    public Teeth(int sharpness) {
        this.sharpness = sharpness;
    }

    public int getSharpness() {
        return sharpness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teeth teeth = (Teeth) o;
        return sharpness == teeth.sharpness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharpness);
    }

    @Override
    public String toString() {
        return "Teeth{" +
                "sharpness=" + sharpness +
                '}';
    }
}

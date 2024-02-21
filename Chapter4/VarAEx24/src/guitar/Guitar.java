package guitar;

import java.util.Objects;

public class Guitar {
    private GuitarString string;
    private Bridge bridge;

    public Guitar(GuitarString string, Bridge bridge) {
        this.string = string;
        this.bridge = bridge;
    }

    public void play() {
        System.out.println("Playing the guitar...");
    }

    public void tune() {
        System.out.println("Tuning the guitar...");
    }

    public void replaceString(GuitarString newString) {
        System.out.println("Replacing the string with " + newString + " string...");
        this.string  = newString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guitar guitar = (Guitar) o;
        return Objects.equals(string, guitar.string) &&
                Objects.equals(bridge, guitar.bridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, bridge);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "string=" + string +
                ", bridge=" + bridge +
                '}';
    }
}

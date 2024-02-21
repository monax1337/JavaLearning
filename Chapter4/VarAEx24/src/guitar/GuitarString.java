package guitar;

import java.util.Objects;

public class GuitarString {
    private String material;

    public GuitarString(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuitarString aString = (GuitarString) o;
        return Objects.equals(material, aString.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material);
    }

    @Override
    public String toString() {
        return "String{" +
                "material='" + material + '\'' +
                '}';
    }
}

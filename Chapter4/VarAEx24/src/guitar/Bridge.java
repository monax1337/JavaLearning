package guitar;

import java.util.Objects;

public class Bridge {
    private String type;

    public Bridge(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return Objects.equals(type, bridge.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public java.lang.String toString() {
        return "Bridge{" +
                "type='" + type + '\'' +
                '}';
    }
}

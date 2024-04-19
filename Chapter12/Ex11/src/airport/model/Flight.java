package airport.model;

public class Flight {
    private String name;

    public Flight(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Flight " + name;
    }
}

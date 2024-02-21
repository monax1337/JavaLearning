package tours;

public class Tour {
    private String type;
    private String transport;
    private String meals;
    private int duration;

    public Tour(String type, String transport, String meals, int duration) {
        this.type = type;
        this.transport = transport;
        this.meals = meals;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "type='" + type + '\'' +
                ", transport='" + transport + '\'' +
                ", meals='" + meals + '\'' +
                ", duration=" + duration +
                '}';
    }
}

package travel.abstracttours;

import java.io.Serializable;

public abstract class Tour implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String type;
    protected String destination;
    protected String transport;
    protected String accommodation;
    protected int duration;
    protected double price;

    public Tour() {}

    public Tour(String type, String destination, String transport, String accommodation, int duration, double price) {
        this.type = type;
        this.destination = destination;
        this.transport = transport;
        this.accommodation = accommodation;
        this.duration = duration;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

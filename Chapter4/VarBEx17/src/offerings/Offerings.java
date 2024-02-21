package offerings;

import tours.Tour;

import java.util.ArrayList;
import java.util.List;

public class Offerings {
    private List<Tour> offerings;

    public Offerings() {
        this.offerings = new ArrayList<>();
    }

    public void addOffering(Tour offering) {
        offerings.add(offering);
    }

    public void displayOfferings() {
        System.out.println("Available tours:");
        for (Tour tour : offerings) {
            System.out.println(tour);
        }
    }

    public void filterByTransport(String transport) {
        System.out.println("Tours by " + transport + ":");
        for (Tour tour : offerings) {
            if (tour.getTransport().equalsIgnoreCase(transport)) {
                System.out.println(tour);
            }
        }
    }

    public void filterByDuration(int minDuration, int maxDuration) {
        System.out.println("Tours with duration between " + minDuration + " and " + maxDuration + " days:");
        for (Tour tour : offerings) {
            if (tour.getDuration() >= minDuration && tour.getDuration() <= maxDuration) {
                System.out.println(tour);
            }
        }
    }
}

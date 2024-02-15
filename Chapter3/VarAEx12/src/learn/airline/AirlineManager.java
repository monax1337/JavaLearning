package learn.airline;

import java.util.Arrays;

public class AirlineManager {
    private Airline[] airlines;
    private int size;

    public AirlineManager(int quantity) {
        this.airlines = new Airline[quantity];
        this.size = 0;
    }

    public void addAirline(Airline airline) {
        if (size < airlines.length) {
            airlines[size++] = airline;
        } else {
            System.out.println("Массив полный");
        }
    }

    public void printFlightsByDestination(String destination) {
        for (Airline airline : airlines) {
            if (airline.getDestination() == destination) {
                System.out.println(airline.toString());
            }
        }
    }

    public void printFlightsByDayOfWeek(String dayOfWeek) {
        for (Airline airline : airlines) {
            if (Arrays.asList(airline.getDaysOfWeek()).contains(dayOfWeek.toUpperCase())) {
                System.out.println(airline.toString());
            }
        }
    }

    public void printFlightsByDayAndTime(String dayOfWeek, String departureTime) {
        for (Airline airline : airlines) {
            if (Arrays.asList(airline.getDaysOfWeek()).contains(dayOfWeek.toUpperCase()) && airline.getDepartureTime().compareTo(departureTime) > 0) {
                System.out.println(airline.toString());
            }
        }
    }

    public static void main(String[] args) {
        AirlineManager airlineManager = new AirlineManager(3);

        Airline airline1 = new Airline("New York", 101, "Boeing 747", "08:30", new String[]{"MONDAY", "WEDNESDAY", "FRIDAY"});
        Airline airline2 = new Airline("Paris", 202, "Airbus A320", "10:00", new String[]{"TUESDAY", "THURSDAY", "SATURDAY"});
        Airline airline3 = new Airline("London", 303, "Boeing 787", "12:45", new String[]{"MONDAY", "WEDNESDAY", "FRIDAY"});

        airlineManager.addAirline(airline1);
        airlineManager.addAirline(airline2);
        airlineManager.addAirline(airline3);

        System.out.println("Список рейсов для пункта назначения 'Paris':");
        airlineManager.printFlightsByDestination("Paris");

        System.out.println("Список рейсов для вторника:");
        airlineManager.printFlightsByDayOfWeek("TUESDAY");

        System.out.println("Список рейсов для среды, время вылета после 10:00:");
        airlineManager.printFlightsByDayAndTime("WEDNESDAY", "10:00");
    }
}

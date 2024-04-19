import airport.model.Passenger;
import airport.services.Airport;
import airport.model.Flight;
import airport.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport(2, 1);

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("ABC123"));
        flights.add(new Flight("XYZ789"));

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("John"));
        passengers.add(new Passenger("Alice"));

        for (Flight flight : flights) {
            airport.land(flight);
        }

        Terminal terminal = new Terminal(1);
        for (Passenger passenger : passengers) {
            terminal.processPassenger(passenger);
        }

        for (Flight flight : flights) {
            airport.takeoff(flight);
        }

        airport.shutdown();
    }
}
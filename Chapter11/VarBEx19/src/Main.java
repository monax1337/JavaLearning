import entities.Car;
import service.FillCarsService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static service.OvertakesCounterService.overtakesCounter;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = FillCarsService.fillCars();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Number of overtakes to display: ");
            int overtakesToDisplay = scanner.nextInt();

            List<String> overtakes = overtakesCounter(cars, overtakesToDisplay);
            if (overtakes.isEmpty()) {
                System.out.println("No overtakes will occur.");
            } else {
                if (overtakes.size() < overtakesToDisplay) {
                    System.out.println("Only " + overtakes.size() + " overtakes are possible with the given cars.");
                }
                System.out.println("Overtakes:");
                for (String overtake : overtakes) {
                    System.out.println(overtake);
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Input error: Please enter valid integers for position and speed.");
        }
    }
}

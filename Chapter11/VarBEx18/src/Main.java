import entities.Car;
import service.FillCarsService;

import java.util.List;

import static service.OvertakesCounterService.overtakesCounter;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = FillCarsService.fillCars();

        int overtakes = overtakesCounter(cars);
        System.out.println("Number of overtakes: " + overtakes);
    }
}

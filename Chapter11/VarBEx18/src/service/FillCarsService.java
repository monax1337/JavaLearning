package service;

import entities.Car;

import java.util.ArrayList;
import java.util.List;

public class FillCarsService {
    public static List<Car> fillCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(0, 3));
        cars.add(new Car(150, 2));
        cars.add(new Car(200, 1));
        cars.add(new Car(0, 1));

        return cars;
    }
}

package service;

import entities.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OvertakesCounterService {
    public static List<String> overtakesCounter(List<Car> cars, Integer overtakesToDisplay){
        List<String> overtakes = new ArrayList<>();
        int overtakesCount = 0;

        for (int i = 0; i < cars.size(); i++) {
            for (int j = i + 1; j < cars.size() && overtakesCount < overtakesToDisplay; j++) {
                Car car1 = cars.get(i);
                Car car2 = cars.get(j);

                if (car1.getPosition() < car2.getPosition() && car1.getSpeed() > car2.getSpeed()) {
                    double overtakePosition = (car1.getPosition() - car2.getPosition()) / (car2.getSpeed() - car1.getSpeed());
                    overtakes.add("Car " + i + " overtakes car " + j + " at position " + overtakePosition);
                    overtakesCount++;
                }
            }
        }
        return overtakes.stream()
                .sorted(Comparator.comparingDouble(str -> Double.parseDouble(str.split(" ")[7])))
                .collect(Collectors.toList());
    }
}

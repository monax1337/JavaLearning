package service;

import entities.Car;

import java.util.List;

public class OvertakesCounterService {
    public static int overtakesCounter(List<Car> cars){
        int overtakes = 0;

        for (int i = 0; i < cars.size(); i++) {
            for (int j = i + 1; j < cars.size(); j++) {
                Car car1 = cars.get(i);
                Car car2 = cars.get(j);

                if (car1.getPosition() < car2.getPosition() && car1.getSpeed() > car2.getSpeed()) {
                    overtakes++;
                }
            }
        }
        return overtakes;
    }
}

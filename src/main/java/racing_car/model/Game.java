package racing_car.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private static final int START_THRESHOLD = 3;

    private static final int END_THRESHOLD = 10;

    private final Car[] cars;

    public Game(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    private int generateRandomNumber() {
        return new Random().nextInt(END_THRESHOLD);
    }

    private void moveCar(int carIndex, int number) {
        if (number > START_THRESHOLD) {
            cars[carIndex].move(1);
        }
    }

    public void moveCar(int carIndex) {
        int randomNumber = generateRandomNumber();
        moveCar(carIndex, randomNumber);
    }

    public void moveAllCars() {
        for (int i = 0; i < cars.length; i++) {
            moveCar(i);
        }
    }

    public Car[] getWinners() {
        Car maxDistance = Collections.max(Arrays.asList(cars));
        return Arrays.stream(cars)
                .filter(car -> car.compareTo(maxDistance) == 0)
                .collect(Collectors.toList())
                .toArray(Car[]::new);
    }
}

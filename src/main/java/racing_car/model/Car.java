package racing_car.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Car[] from(String names){
        String[] separatedNames = names.split(",");
        Car[] cars = new Car[separatedNames.length];
        for (int i = 0; i < separatedNames.length; i++) {
            cars[i] = new Car(separatedNames[i]);
        }
        return cars;
    }

    public String showDistance() {
        return "-".repeat(this.distance);
    }

    public void move(int i) {
        this.distance += i;
    }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }
}

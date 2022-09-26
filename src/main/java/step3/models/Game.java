package step3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import step3.utils.RandomSingleton;

public class Game {
    static final String CREATE_ERROR_MSG = "횟수에 음수는 들어올 수 없습니다.";
    private final int carNumber;
    private final int tryNumber;

    public Game(int carNumber, int tryNumber) {
        if (carNumber < 0 || tryNumber < 0) {
            throw new IllegalArgumentException(CREATE_ERROR_MSG);
        }

        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public List<List<Car>> play() {
        List<List<Car>> results = new ArrayList<>();

        results.add(initCars());

        for (int i = 0; i < tryNumber; ++i) {
            List<Car> previousCars = results.get(i);
            results.add(moveCars(previousCars));
        }

        return results.stream().skip(1).collect(Collectors.toList());
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; ++i) {
            cars.add(new Car());
        }
        return cars;
    }

    private List<Car> moveCars(List<Car> cars) {
        Random random = RandomSingleton.INSTANCE.getInstance();
        return cars.stream().map(car -> car.move(random.nextInt(10))).collect(Collectors.toList());
    }
}

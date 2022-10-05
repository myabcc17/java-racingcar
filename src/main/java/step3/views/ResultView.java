package step3.views;

import java.util.List;
import java.util.stream.Collectors;

import step3.domains.Car;
import step3.domains.GameResult;

public class ResultView {
    private static final char MOVE_CHARACTER = '-';
    private static final String TITLE = "실행 결과";
    private static final String WINNER_TITLE_FORMAT = "%s가 최종 우승했습니다.";

    private final GameResult gameResult;

    public ResultView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void printWinnerList() {
        String winner = gameResult.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(String.format(WINNER_TITLE_FORMAT, winner));
    }

    public void printResult() {
        System.out.println(TITLE);
        gameResult.getResults().forEach(result -> {
            printCars(result);
            System.out.println();
        });
    }

    private void printCars(List<Car> cars) {
        cars.forEach(this::printCar);
    }

    private void printCar(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition().getPosition(); ++i) {
            System.out.print(MOVE_CHARACTER);
        }

        System.out.println();
    }
}

package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
		List<String> names = InputView.readCarNames();
		System.out.println("입력된 이름: " + names);

		int rounds = InputView.readRounds();
		System.out.println("입력된 횟수: " + rounds);

		Car car1 = new Car("pobi");
		car1.move(true);
		car1.move(true);

		Car car2 = new Car("woni");
		car2.move(true);

		Car car3 = new Car("jun");
		car3.move(true);
		car3.move(true);
		car3.move(true);

		List<Car> cars = List.of(car1, car2, car3);

		OutputView.printResultHeader();
		OutputView.printRoundResult(cars);
    }
}

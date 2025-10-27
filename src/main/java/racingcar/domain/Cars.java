package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<String> names) {
		this.cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public void moveAll(List<Boolean> moveConditions) {
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).move(moveConditions.get(i));
		}
	}

	public List<String> findWinners() {
		int maxPosition = findMaxPosition();
		return findCarNamesAtPosition(maxPosition);
	}

	private int findMaxPosition() {
		int max = 0;
		for (Car car : cars) {
			if (car.getPosition() > max) {
				max = car.getPosition();
			}
		}
		return max;
	}

	private List<String> findCarNamesAtPosition(int position) {
		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == position) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

	@Test
	@DisplayName("1: 자동차 위치를 문자열로 변환 (위치 3)")
	void test1() {
		Car car = new Car("pobi");
		car.move(true);
		car.move(true);
		car.move(true);

		String position = OutputView.formatPosition(car);

		assertThat(position).isEqualTo("---");
	}

	@Test
	@DisplayName("2: 여러 자동차 상태를 리스트로 변환")
	void test2() {
		Car car1 = new Car("pobi");
		car1.move(true);

		Car car2 = new Car("woni");
		car2.move(true);
		car2.move(true);

		Car car3 = new Car("jun");

		List<Car> cars = List.of(car1, car2, car3);
		List<String> lines = OutputView.formatAllCarsStatus(cars);

		assertThat(lines).containsExactly(
			"pobi : -",
			"woni : --",
			"jun : "
		);
	}
}
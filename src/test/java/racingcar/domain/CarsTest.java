package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

	@Test
	@DisplayName("1: 여러 자동차를 관리한다")
	void test1() {
		List<String> names = List.of("pobi", "woni", "jun");
		Cars cars = new Cars(names);

		assertThat(cars.getCars()).hasSize(3);
	}

	@Test
	@DisplayName("2: 모든 자동차를 이동시킨다")
	void test2() {
		List<String> names = List.of("pobi", "woni");
		Cars cars = new Cars(names);

		// 모두 전진
		cars.moveAll(List.of(true, true));

		List<Car> carList = cars.getCars();
		assertThat(carList.get(0).getPosition()).isEqualTo(1);
		assertThat(carList.get(1).getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("3: 일부 자동차만 이동시킨다")
	void test3() {
		List<String> names = List.of("pobi", "woni", "jun");
		Cars cars = new Cars(names);

		// pobi만 전진, 나머지는 정지
		cars.moveAll(List.of(true, false, false));

		List<Car> carList = cars.getCars();
		assertThat(carList.get(0).getPosition()).isEqualTo(1);
		assertThat(carList.get(1).getPosition()).isEqualTo(0);
		assertThat(carList.get(2).getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("4: 단독 우승자를 찾는다")
	void test4() {
		List<String> names = List.of("pobi", "woni", "jun");
		Cars cars = new Cars(names);

		// pobi: 3, woni: 1, jun: 2
		cars.moveAll(List.of(true, true, true));
		cars.moveAll(List.of(true, false, true));
		cars.moveAll(List.of(true, false, false));

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactly("pobi");
	}

	@Test
	@DisplayName("5: 공동 우승자를 찾는다")
	void test5() {
		List<String> names = List.of("pobi", "woni", "jun");
		Cars cars = new Cars(names);

		// pobi: 2, woni: 1, jun: 2
		cars.moveAll(List.of(true, true, true));
		cars.moveAll(List.of(true, false, true));

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
	}

	@Test
	@DisplayName("6: 모두 우승자일 수 있다")
	void test6() {
		List<String> names = List.of("pobi", "woni", "jun");
		Cars cars = new Cars(names);

		// 모두 이동하지 않음 (위치 0)
		cars.moveAll(List.of(false, false, false));

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
	}

}
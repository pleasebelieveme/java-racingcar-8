package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	@Test
	@DisplayName("1: Car는 name과 position을 가진다")
	void test1() {
		Car car = new Car("pobi");

		assertThat(car.getName()).isEqualTo("pobi");
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("2: 전진하면 위치가 1증가한다")
	void test2() {
		Car car = new Car("pobi");

		car.move(true);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("3: 여러번 전진할 수 있다")
	void test3() {
		Car car = new Car("pobi");

		car.move(true);
		car.move(true);
		car.move(true);

		assertThat(car.getPosition()).isEqualTo(3);
	}

	@Test
	@DisplayName("4: 정지하면 위치가 변하지 않는다")
	void test4() {
		Car car = new Car("pobi");

		car.move(false);

		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("5: 전진과 지를 반복할 수 있다")
	void test5() {
		Car car = new Car("pobi");

		car.move(true);   // 1
		car.move(false);  // 1
		car.move(true);   // 2
		car.move(true);   // 3

		assertThat(car.getPosition()).isEqualTo(3);
	}
}
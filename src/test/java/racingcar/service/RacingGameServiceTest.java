package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameServiceTest {

	@Test
	@DisplayName("1: 올바른 이름과 라운드로 게임 실행 시 예외 없이 완료된다")
	void test1() {
		RacingGameService service = new RacingGameService();

		List<String> names = List.of("pobi", "woni", "jun");
		int rounds = 3;

		// 예외가 발생하지 않으면 성공
		service.play(names, rounds);
	}

	@Test
	@DisplayName("2: 라운드 수가 0이면 예외 발생")
	void test2() {
		RacingGameService service = new RacingGameService();

		List<String> names = List.of("pobi", "woni");

		assertThatThrownBy(() -> service.play(names, 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("라운드 수는 1 이상이어야 합니다.");
	}

	@Test
	@DisplayName("3: 자동차 이름이 비어 있으면 예외 발생")
	void test3() {
		RacingGameService service = new RacingGameService();

		List<String> names = List.of("", "woni");
		int rounds = 2;

		assertThatThrownBy(() -> service.play(names, rounds))
			.isInstanceOf(IllegalArgumentException.class);
	}


	@Test
	@DisplayName("4: 우승자를 정상적으로 찾을 수 있다")
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
}

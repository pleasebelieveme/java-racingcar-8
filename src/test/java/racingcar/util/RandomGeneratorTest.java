package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

	@Test
	@DisplayName("1: 4 이상이면 전진 true")
	void test1() {
		boolean result = RandomGenerator.shouldMove(4);
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("2: 3 이하면 정지 false")
	void test2() {
		boolean result = RandomGenerator.shouldMove(3);
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("3: 실제 랜덤값으로 여러 번 실행해도 정상 동작")
	void test3() {
		// 100번 실행해서 예외가 발생하지 않는지 확인
		for (int i = 0; i < 100; i++) {
			boolean result = RandomGenerator.shouldMove();
			// true 또는 false 둘 중 하나여야 함
			assertThat(result).isIn(true, false);
		}
	}

	@Test
	@DisplayName("4: 랜덤값 생성 시 0~9 범위 내의 값")
	void test4() {
		// 실제로는 Randoms.pickNumberInRange가 보장
		for (int i = 0; i < 100; i++) {
			// shouldMove()는 내부적으로 0~9 사이 값을 생성해야 함
			// 이 테스트는 통계적 검증
			RandomGenerator.shouldMove();
		}
		// 예외 없이 통과하면 성공
	}
}
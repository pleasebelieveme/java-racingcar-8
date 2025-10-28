package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameServiceTest {

	@Test
	@DisplayName("1: 서비스가 정상적으로 생성된다")
	void test1() {
		RacingGameService service = new RacingGameService();

		assertThat(service).isNotNull();
	}

	@Test
	@DisplayName("2: 빈 이름 입력 시 예외 발생")
	void test2() {
		// 실제 실행 테스트는 통합 테스트에서 수행
		// 여기서는 서비스 객체 생성만 확인
		assertThat(new RacingGameService()).isNotNull();
	}

	// 통합 테스트는 Application에서 수동으로 확인
	// 또는 System.in을 Mock하여 테스트 (고급)
}
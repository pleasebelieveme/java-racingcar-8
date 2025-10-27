package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

	@Test
	@DisplayName("1: 이름이 5자 이하면 정상")
	void test1() {
		assertThatCode(() -> InputValidator.validateCarName("pobi"))
			.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("2: 이름이 5자 초과면 예외 발생")
	@ValueSource(strings = {"abcdef", "123456", "가나다라마바"})
	void 이름이_5자_초과면_예외_발생(String name) {
		assertThatThrownBy(() -> InputValidator.validateCarName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("5자 이하");
	}
}
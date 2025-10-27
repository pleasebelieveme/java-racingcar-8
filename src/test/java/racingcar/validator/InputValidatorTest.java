package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class InputValidatorTest {

	@Test
	@DisplayName("1: 이름이 5자 이하면 정상")
	void test1() {
		assertThatCode(() -> InputValidator.validateCarName("pobi2"))
			.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("2: 이름이 5자 초과면 예외 발생")
	@ValueSource(strings = {"abcdef", "123456", "가나다라마바"})
	void test2(String name) {
		assertThatThrownBy(() -> InputValidator.validateCarName(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 5자 이하여야 합니다");
	}

	@Test
	@DisplayName("3: 빈 문자열이면 예외 발생")
	void test3() {
		assertThatThrownBy(() -> InputValidator.validateCarName(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 비어있을 수 없습니다");
	}

	@Test
	@DisplayName("4: 이름이 5자 초과면 예외 발생")
	void test4() {
		assertThatThrownBy(() -> InputValidator.validateCarName(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 비어있을 수 없습니다");
	}

	@Test
	@DisplayName("5: 공백만 있으면 예외 발생")
	void test5() {
		assertThatThrownBy(() -> InputValidator.validateCarName("   "))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 비어있을 수 없습니다");
	}

	@Test
	@DisplayName("6: 중복된 이름이 있으면 예외 발생")
	void test6() {
		List<String> names = List.of("pobi", "woni", "pobi");

		assertThatThrownBy(() -> InputValidator.validateNoDuplicateNames(names))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 중복이 될 수 없습니다");
	}

	@Test
	@DisplayName("7: 대소문자 구분하여 중복 체크")
	void test7() {
		List<String> names = List.of("pobi", "Pobi", "POBI");

		// 대소문자를 다른 이름으로 간주
		assertThatCode(() -> InputValidator.validateNoDuplicateNames(names))
			.doesNotThrowAnyException();
	}
}
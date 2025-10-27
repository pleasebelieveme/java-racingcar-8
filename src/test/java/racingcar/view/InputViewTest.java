package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class InputViewTest {

	@Test
	@DisplayName("1: 쉼표로 구분된 이름을 리스트로 변환")
	void test1() {
		String input = "pobi,woni,jun";
		List<String> names = InputView.parseCarNames(input);

		assertThat(names).containsExactly("pobi", "woni", "jun");
	}

	@Test
	@DisplayName("2: 단일 이름도 처리")
	void test2() {
		String input = "pobi";
		List<String> names = InputView.parseCarNames(input);

		assertThat(names).containsExactly("pobi");
	}

	@Test
	@DisplayName("3: 빈 문자열은 빈 리스트 반환")
	void test3() {
		String input = "";
		List<String> names = InputView.parseCarNames(input);

		assertThat(names).containsExactly("");
	}

	@Test
	@DisplayName("4: 연속된 쉼표는 빈 문자열 포함")
	void test4() {
		String input = "pobi,,jun";
		List<String> names = InputView.parseCarNames(input);

		// trim 후 빈 문자열은 제거되지 않음 (validator에서 처리)
		assertThat(names).containsExactly("pobi", "", "jun");
	}

	@Test
	@DisplayName("5: 앞뒤 공백 제거")
	void test5() {
		String input = "  pobi  ,  woni  ";
		List<String> names = InputView.parseCarNames(input);

		assertThat(names).containsExactly("pobi", "woni");
	}

	@Test
	@DisplayName("6: 정수 문자열을 int로 변환")
	void test6() {
		String input = "5";
		int rounds = InputView.parseRounds(input);

		assertThat(rounds).isEqualTo(5);
	}

	@Test
	@DisplayName("7: 공백이 포함된 숫자는 trim 후 변환")
	void test7() {
		String input = "  5  ";
		int rounds = InputView.parseRounds(input);

		assertThat(rounds).isEqualTo(5);
	}

	@Test
	@DisplayName("8: 숫자가 아니면 IllegalArgumentException 발생")
	void test8() {
		String input = "abc";

		assertThatThrownBy(() -> InputView.parseRounds(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이동 횟수는 숫자여야 합니다");
	}

	@Test
	@DisplayName("9: 소수점이 있으면 IllegalArgumentException 발생")
	void test9() {
		String input = "5.5";

		assertThatThrownBy(() -> InputView.parseRounds(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이동 횟수는 숫자여야 합니다");
	}

	@Test
	@DisplayName("10: 빈 문자열이면 IllegalArgumentException 발생")
	void test10() {
		String input = "";

		assertThatThrownBy(() -> InputView.parseRounds(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("이동 횟수는 숫자여야 합니다");
	}
}
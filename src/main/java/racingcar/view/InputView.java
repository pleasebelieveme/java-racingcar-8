package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ROUNDS_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
	private static final String DELIMITER = ",";

	private InputView() {
		throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
	}

	public static String readCarNamesInput() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String readRoundsInput() {
		System.out.println(ROUNDS_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static List<String> parseCarNames(String input) {
		return Arrays.stream(input.split(DELIMITER))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static int parseRounds(String input) {
		try {
			return Integer.parseInt(input.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다");
		}
	}
}
package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_ROUNDS = 1;

	private InputValidator() {
		throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
	}

	public static void validateCarName(String name) {
		validateNameNotEmpty(name);
		validateLength(name);
	}

	public static void validateCarNames(List<String> names) {
		if (names.isEmpty()) {
			throw new IllegalArgumentException("최소 1개 이상의 자동차 이름이 필요합니다");
		}
		for (String name : names) {
			validateCarName(name);
		}
		validateNoDuplicateNames(names);
	}

	public static void validateNoDuplicateNames(List<String> names) {
		Set<String> uniqueNames = new HashSet<>(names);
		if (uniqueNames.size() != names.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복이 될 수 없습니다");
		}
	}

	public static void validateRounds(String input) {
		validateRoundsNotEmpty(input);
		int rounds = parseRounds(input);
		validatePositiveRounds(rounds);
	}

	private static void validateNameNotEmpty(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다");
		}
	}

	private static void validateRoundsNotEmpty(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("이동 횟수는 비어있을 수 없습니다");
		}
	}

	private static void validateLength(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
		}
	}

	private static int parseRounds(String input) {
		try {
			return Integer.parseInt(input.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다");
		}
	}

	private static void validatePositiveRounds(int rounds) {
		if (rounds < MIN_ROUNDS) {
			throw new IllegalArgumentException("이동 횟수는 1이상이어야 합니다");
		}
	}
}
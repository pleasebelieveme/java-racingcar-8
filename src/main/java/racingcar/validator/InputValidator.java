package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
	private static final int MAX_NAME_LENGTH = 5;

	private InputValidator() {
		throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다");
	}

	public static void validateCarName(String name) {
		validateNotEmpty(name);
		validateLength(name);
	}

	public static void validateCarNames(List<String> names) {
		if (names.isEmpty()) {
			throw new IllegalArgumentException("최소 1개 이상의 자동차 이름이 필요합니다.");
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

	private static void validateNotEmpty(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다");
		}
	}

	private static void validateLength(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
		}
	}
}
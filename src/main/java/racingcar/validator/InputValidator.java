package racingcar.validator;

public class InputValidator {
	private static final int MAX_NAME_LENGTH = 5;

	public static void validateCarName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
		}
	}
}
package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;
	private static final int MOVE_THRESHOLD = 4;

	private RandomGenerator() {
		throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
	}

	public static boolean shouldMove() {
		int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
		return shouldMove(randomValue);
	}

	public static boolean shouldMove(int randomValue) {
		return randomValue >= MOVE_THRESHOLD;
	}
}
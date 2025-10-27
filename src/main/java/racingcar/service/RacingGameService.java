package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.RandomGenerator;
import racingcar.validator.InputValidator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

	public void play(List<String> names, int rounds) {
		// 1️⃣ 입력 검증
		InputValidator.validateCarNames(names);
		validateRounds(rounds);

		// 2️⃣ 자동차 목록 생성
		Cars cars = new Cars(names);

		// 3️⃣ 결과 헤더 출력
		OutputView.printResultHeader();

		// 4️⃣ 각 라운드 실행
		for (int i = 0; i < rounds; i++) {
			moveCars(cars);
			OutputView.printRoundResult(cars.getCars());
		}

		// 5️⃣ 우승자 출력
		List<String> winners = cars.findWinners();
		OutputView.printWinners(winners);
	}

	private void moveCars(Cars cars) {
		List<Boolean> moveConditions = new ArrayList<>();
		for (int i = 0; i < cars.getCars().size(); i++) {
			moveConditions.add(RandomGenerator.shouldMove());
		}
		cars.moveAll(moveConditions);
	}

	private void validateRounds(int rounds) {
		if (rounds < 1) {
			throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
		}
	}
}

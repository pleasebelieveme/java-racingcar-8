package racingcar.service;

import racingcar.domain.Cars;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameService {

	public void start() {
		List<String> carNames = readAndValidateCarNames();
		int rounds = readAndValidateRounds();

		Cars cars = new Cars(carNames);

		runRacing(cars, rounds);
		printWinners(cars);
	}

	private List<String> readAndValidateCarNames() {
		String input = InputView.readCarNamesInput();
		List<String> names = InputView.parseCarNames(input);
		InputValidator.validateCarNames(names);
		return names;
	}

	private int readAndValidateRounds() {
		String input = InputView.readRoundsInput();
		InputValidator.validateRounds(input);
		return InputView.parseRounds(input);
	}

	private void runRacing(Cars cars, int rounds) {
		OutputView.printResultHeader();
		for (int i = 0; i < rounds; i++) {
			cars.moveAll();
			OutputView.printRoundResult(cars.getCars());
		}
	}

	private void printWinners(Cars cars) {
		List<String> winners = cars.findWinners();
		OutputView.printWinners(winners);
	}
}
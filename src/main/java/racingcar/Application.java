package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
		List<String> names = InputView.readCarNames();
		int rounds = InputView.readRounds();

		RacingGameService racingGameService = new RacingGameService();
		racingGameService.play(names, rounds);
    }
}

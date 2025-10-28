package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		try {
			RacingGameService service = new RacingGameService();
			service.start();
		} catch (IllegalArgumentException e) {
			// 아무 것도 안 함 (조용히 종료)
			// 리펙토링 필요
			System.out.println(e.getMessage());
			throw e;
		}
	}
}

package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String RESULT_HEADER = "\n실행 결과";
	private static final String POSITION_SYMBOL = "-";
	private static final String STATUS_DELIMITER = " : ";
	private static final String WINNER_PREFIX = "최종 우승자 : ";
	private static final String WINNER_DELIMITER = ", ";

	private OutputView() {
		throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
	}

	public static void printResultHeader() {
		System.out.println(RESULT_HEADER);
	}

	public static void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(formatCarStatus(car));
		}
		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		System.out.println(formatWinners(winners));
	}

	public static String formatCarStatus(Car car) {
		return car.getName() + STATUS_DELIMITER + formatPosition(car);
	}

	public static String formatPosition(Car car) {
		return POSITION_SYMBOL.repeat(car.getPosition());
	}

	public static List<String> formatAllCarsStatus(List<Car> cars) {
		return cars.stream()
			.map(OutputView::formatCarStatus)
			.collect(Collectors.toList());
	}

	public static String formatWinners(List<String> winners) {
		return WINNER_PREFIX + joinWinnerNames(winners);
	}

	public static String joinWinnerNames(List<String> winners) {
		return String.join(WINNER_DELIMITER, winners);
	}
}
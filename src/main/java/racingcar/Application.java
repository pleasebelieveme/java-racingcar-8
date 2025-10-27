package racingcar;

import java.util.List;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
		List<String> names = InputView.readCarNames();
		System.out.println("입력된 이름: " + names);
    }
}

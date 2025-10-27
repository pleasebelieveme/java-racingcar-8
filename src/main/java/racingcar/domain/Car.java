package racingcar.domain;

public class Car {
	private final String name;
	private int position;

	public Car(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다");
		}
		this.name = name;
		this.position = 0;
	}

	public void move(boolean shouldMove) {
		if (shouldMove) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
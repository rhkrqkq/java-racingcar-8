package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int FORWARD_CONDITION = 4;
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
	}

	public void move() { // 자동차 전진, 정지 함수
		int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
		if (randomNumber >= FORWARD_CONDITION) {
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

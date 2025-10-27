package racingcar.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.model.Car;

public class RacingService {

	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_CAR_COUNT = 2;

	public List<Car> setupCars(String carNamesInput) {
		List<String> names = splitAndTrimNames(carNamesInput);
		validateCarNames(names);

		return names.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private List<String> splitAndTrimNames(String carNamesInput) {
		return Arrays.stream(carNamesInput.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
	}


	private void validateCarNames(List<String> names) {  // 예외처리 (이름)
		for (String name : names) {
			validateNameLength(name);
		}
		validateDuplicateNames(names);
		validateMinCarCount(names);
	}

	private void validateNameLength(String name) {
		if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
		}
	}

	private void validateMinCarCount(List<String> names) {
		if (names.size() < MIN_CAR_COUNT) {
			throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
		}
	}

	private void validateDuplicateNames(List<String> names) {
		Set<String> uniqueNames = new HashSet<>(names);
		if (uniqueNames.size() != names.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}


	public int validateTryCount(String tryCountInput) {  // 예외처리 (시도횟수)
		try {
			int count = Integer.parseInt(tryCountInput);
			validatePositiveTryCount(count);
			return count;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
		}
	}

	private void validatePositiveTryCount(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
		}
	}

	public void runSingleRound(List<Car> cars) {  // 자동차 전진
		for (Car car : cars) {
			car.move();
		}
	}

	public List<String> findWinners(List<Car> cars) {  // 우승자 선정
		int maxPosition = findMaxPosition(cars);

		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int findMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}

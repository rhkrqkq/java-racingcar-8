package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {

	private OutputView() {
	}

	public static void printRaceStart() {
		System.out.println("\n실행 결과");
	}

	public static void printRoundResult(List<Car> cars) {  // 라운드 결과
		for (Car car: cars) {
			System.out.println(car.getName() + " : " + positionToFoward(car.getPosition()));
		}
		System.out.println();
	}

	private static String positionToFoward(int position) {  // position을 "-"로 변환
		StringBuilder forward = new StringBuilder();
		for (int i=0; i<position; i++) {
			forward.append("-");
		}
		return forward.toString();
	}

	public static void printWinners(List<String> winners) {
		String winnerNames = String.join(", ", winners);
		System.out.println("최종 우승자 : " + winnerNames);
	}
}

package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

	private final RacingService racingService;

	public RaceController() {
		this.racingService = new RacingService();
	}

	public void run() {
		List<Car> cars = setupCars();
		int tryCount = setupTryCount();

		OutputView.printRaceStart();
		runRace(cars, tryCount);

		List<String> winners = racingService.findWinners(cars);
		OutputView.printWinners(winners);
	}

	private List<Car> setupCars() {
		String nameInput = InputView.readCarName();
		return racingService.setupCars(nameInput);
	}

	private int setupTryCount() {
		String tryCountInput = InputView.readTryCount();
		return racingService.validateTryCount(tryCountInput);
	}

	private void runRace(List<Car> cars, int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			racingService.runSingleRound(cars);
			OutputView.printRoundResult(cars);
		}
	}
}

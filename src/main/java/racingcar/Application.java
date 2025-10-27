package racingcar;

import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        try {
            RaceController gameController = new RaceController();
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());  // 예외 발생 시 종료
        }
    }
}

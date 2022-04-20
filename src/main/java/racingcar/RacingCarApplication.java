package racingcar;

import racingcar.controller.RacingCar;
import racingcar.domain.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        NumberGenerator numberGenerator = new NumberGenerator();
        ResultView resultView = new ResultView();

        RacingCar racingCar = new RacingCar(inputView, numberGenerator, resultView);
        racingCar.run();
    }
}
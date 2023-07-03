package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    @DisplayName("유효한 자동차 이름일 경우 true를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "a", " a "})
    void 자동차_입력_검증_성공(String carNames) {
        assertThat(RacingCar.isValidCarNames(carNames)).isEqualTo(true);
    }

    @DisplayName("유효하지 않은 자동차 이름일 경우 false를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,croong,honux", "pobi,,honux", ",,,,"})
    void 자동차_입력_검증_실패(String carNames) {
        assertThat(RacingCar.isValidCarNames(carNames)).isEqualTo(false);
    }

}


package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.DefaultMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    public static final String CAR_NAME = "testCar";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME, new DefaultMovingStrategy());
    }

    @Test
    @DisplayName("자동차 이름 반환")
    void returnCarName() {
        assertThat(car.getCarName()).isEqualTo(CAR_NAME);
    }

    @DisplayName("입력값이 0-4 일 경우 이동하지 않음")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void stopWhenInputZeroToFour(int input) {
        int beforeLocation = car.getCurrentLocation();
        car.move(input);
        int afterLocation = car.getCurrentLocation();

        assertThat(afterLocation).isEqualTo(beforeLocation);
    }

    @DisplayName("입력값이 5-10 일 경우 이동")
    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9, 10})
    void moveWhenInputFiveToTen(int input) {
        int beforeLocation = car.getCurrentLocation();
        car.move(input);
        int afterLocation = car.getCurrentLocation();

        assertThat(afterLocation).isEqualTo(beforeLocation + 1);
    }
}
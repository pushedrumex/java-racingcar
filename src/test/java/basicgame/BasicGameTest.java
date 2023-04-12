package basicgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static basicgame.CarGroup.INPUT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BasicGameTest {

    @DisplayName("전진 가능 여부 테스트")
    @MethodSource("isEnoughToGoTestArguments")
    @ParameterizedTest
    void isEnoughToGoTest(int value, boolean expected) {
        Car car = new Car(new StringBuffer());

        boolean actual = car.isEnoughValue(value);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> isEnoughToGoTestArguments() {
        return Stream.of(
                Arguments.of(-5, false),
                Arguments.of(-4, false),
                Arguments.of(-3, false),
                Arguments.of(-2, false),
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true),
                Arguments.of(8, true),
                Arguments.of(9, true)
        );
    }

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Success")
    void inputUiTestSuccess() {
        var expectedCarCount = 3;
        var expectedTryCount = 5;

        var actualCarCount = 3;
        var actualTryCount = 5;
        CarGroup.startGame(actualCarCount, actualTryCount);

        assertThat(CarGroup.carsSize()).isEqualTo(expectedCarCount);
        assertThat(CarGroup.triedCount.getValue()).isEqualTo(expectedTryCount);
    }

    @Test
    @DisplayName("자동차 대수, 시도 횟수 입력 테스트 Fail")
    void inputUiTestFailure() {
        var carCount = -1;
        var tryCount = 5;

        assertThatThrownBy(() -> CarGroup.startGame(carCount, tryCount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ERROR_MESSAGE);
    }
}
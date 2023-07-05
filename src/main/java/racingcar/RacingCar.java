package racingcar;

import java.text.MessageFormat;
import java.util.Arrays;

public class RacingCar {

    public int moveCount =0;
    public String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public static boolean isValidCarNames(String rawCarNames) {
        String[] carNames = rawCarNames.split(",");
        return !isEmptyCarNames(carNames) && isValidCarNamesLength(carNames);
    }

    private static boolean isValidCarNamesLength(String[] carNames) {
        boolean result = true;
        for (String carName : carNames) {
            result &= isValidCarNameLength(carName.trim());
        }
        return result;
    }

    private static boolean isEmptyCarNames(String[] carNames) {
        if (carNames.length == 0) {
            return true;
        }
        return false;
    }

    private static boolean isValidCarNameLength(String carName) {
        if (carName.length() > 5 || carName.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean isValidCount(String count) {
        return count.trim().matches("^[0-9]+$");
    }

    public static int generateRandom() {
        return (int) (Math.random() * 10000) % 10;
    }

    public static RacingCar[] generateCarArray(String input) {
        String[] carNames = input.split(",");

        return  Arrays.stream(carNames)
                .map(name -> new RacingCar(name.trim()))
                .toArray(RacingCar[]::new);
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, "-".repeat(moveCount));
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.moveCount++;
        }
    }


}

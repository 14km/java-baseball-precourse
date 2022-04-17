package baseball.common.util;

public class NumberUtil {

    public static boolean isInteger(String inputString) {
        if (inputString == null) {
            return false;
        }

        try {
            for (String input : inputString.split("")) {
                int result = Integer.parseInt(input);

                if (!(result >= 1 && result <= 9)) {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }
}

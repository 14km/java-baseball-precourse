package baseball.common.utils;

public class NumberUtil {

    public static boolean isNotNumber(String inputString) {
        if (inputString == null) {
            return true;
        }

        try {
            isValid(inputString);
        } catch (NumberFormatException exception) {
            return true;
        }

        return false;
    }

    private static void isValid(String inputString) {
        for (String input : inputString.split("")) {
            int result = Integer.parseInt(input);

            availableRangeValid(result);
        }
    }

    private static void availableRangeValid(int number) {
        if (!(number >= 1 && number <= 9)) {
            throw new NumberFormatException();
        }
    }
}

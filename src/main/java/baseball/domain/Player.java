package baseball.domain;

import baseball.common.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int DRAW_COUNT = 3;
    private final List<Integer> inputNumbers = new ArrayList<>();

    public List<Integer> inputNumber(String inputString) {
        isValid(inputString);

        for (String input : inputString.split("")) {
            int result = Integer.parseInt(input);
            inputNumbers.add(result);
        }

        return inputNumbers;
    }

    private void isValid(String inputString) {
        if (!NumberUtil.isInteger(inputString)) {
            throw new IllegalArgumentException("숫자를 입력해주시기 바랍니다. (입력값:" + inputString + ")");
        }

        if (inputString.length() > DRAW_COUNT) {
            throw new IllegalArgumentException("숫자는 " + DRAW_COUNT + "자리까지 입력이 가능합니다. (111 ~ 999)");
        }
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }
}

package baseball.domain;

import baseball.common.utils.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> inputNumbers = new ArrayList<>();

    public void inputNumber(String inputString) {
        isValid(inputString);

        clear();
        for (String input : inputString.split("")) {
            int result = Integer.parseInt(input);
            inputNumbers.add(result);
        }
    }

    // TODO : 중복된 숫자를 확인하는 검증이 필요함.
    private void isValid(String inputString) {
        if (!NumberUtil.isInteger(inputString)) {
            throw new IllegalArgumentException(String.format("1부터 9까지의 숫자를 입력해주시기 바랍니다. (입력값: %s)", inputString));
        }

        if (inputString.length() > GameOption.DRAW_COUNT) {
            throw new IllegalArgumentException(String.format("숫자는 %s 자리까지 입력이 가능합니다. (111 ~ 999)", GameOption.DRAW_COUNT));
        }
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    private void clear() {
        inputNumbers.clear();
    }
}

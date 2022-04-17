package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MIN_NUMBER_SIZE = 1;
    private static final int MAX_NUMBER_SIZE = 9;
    private static final int DRAW_COUNT = 3;

    private final List<Integer> randomsNumbers = new ArrayList<>();

    public void pickNumber() {
        clear();
        do {
            addRandomsNumber(Randoms.pickNumberInRange(MIN_NUMBER_SIZE, MAX_NUMBER_SIZE));
        } while (randomsNumbers.size() < DRAW_COUNT);
    }

    private void clear() {
        randomsNumbers.clear();
    }

    private void addRandomsNumber(int number) {
        if (!this.randomsNumbers.contains(number)) {
            this.randomsNumbers.add(number);
        }
    }

    public List<Integer> getRandomsNumbers() {
        return randomsNumbers;
    }
}

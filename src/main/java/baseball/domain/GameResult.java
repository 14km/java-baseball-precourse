package baseball.domain;

import baseball.common.enums.GameStatus;

public class GameResult {
    private int strikeCounter = 0;
    private int ballCounter = 0;

    public void addResult(GameStatus Status) {
        if (GameStatus.STRIKE == Status) strikeCounter++;
        if (GameStatus.BALL == Status) ballCounter++;
    }

    public int getStrikeCounter() {
        return strikeCounter;
    }

    public int getBallCounter() {
        return ballCounter;
    }
}

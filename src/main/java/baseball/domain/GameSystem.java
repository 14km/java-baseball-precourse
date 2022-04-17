package baseball.domain;

import baseball.common.enums.GameStatus;

import java.util.List;

public class GameSystem {
    private final List<Integer> playerNumberList;
    private final List<Integer> computerNumberList;

    public GameSystem(List<Integer> playerNumberList, List<Integer> computerNumberList) {
        this.playerNumberList = playerNumberList;
        this.computerNumberList = computerNumberList;
    }

    public GameResult play() {
        isValid();

        GameResult gameResult = new GameResult();
        for (int i = 0; i < playerNumberList.size(); i++) {
            GameStatus gameStatus = checkStatus(playerNumberList.get(i), computerNumberList.get(i));
            gameResult.addResult(gameStatus);
        }

        return gameResult;
    }

    private GameStatus checkStatus(int playerNumber, int computerNumber) {
        if (computerNumber == playerNumber) return GameStatus.STRIKE;
        if (computerNumberList.contains(playerNumber)) return GameStatus.BALL;
        return GameStatus.NOTHING;
    }

    private void isValid() {
        if (computerNumberList.size() == 0 || playerNumberList.size() == 0) {
            throw new IllegalArgumentException("컴퓨터 숫자 또는 플레이어에 숫자가 설정되지 않았습니다.");
        }

        if (computerNumberList.size() != playerNumberList.size()) {
            throw new IllegalArgumentException("게임 실행시 필요한 숫자가 일치하지 않습니다.");
        }
    }
}

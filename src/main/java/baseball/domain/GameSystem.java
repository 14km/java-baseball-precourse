package baseball.domain;

import baseball.common.enums.GameStatus;

public class GameSystem {
    private final Player player;
    private final Computer computer;

    public GameSystem(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public GameResult play() {
        isValid();

        GameResult gameResult = new GameResult();
        for (int i = 0; i < player.getInputNumbers().size(); i++) {
            GameStatus gameStatus = checkStatus(player.getInputNumbers().get(i), computer.getRandomsNumbers().get(i));
            gameResult.addResult(gameStatus);
        }

        return gameResult;
    }

    private GameStatus checkStatus(int playerNumber, int computerNumber) {
        if (computerNumber == playerNumber) return GameStatus.STRIKE;
        if (computer.getRandomsNumbers().contains(playerNumber)) return GameStatus.BALL;
        return GameStatus.NOTHING;
    }

    private void isValid() {
        if (computer.getRandomsNumbers().size() == 0 || player.getInputNumbers().size() == 0) {
            throw new IllegalArgumentException("컴퓨터 숫자 또는 플레이어에 숫자가 설정되지 않았습니다.");
        }

        if (computer.getRandomsNumbers().size() != player.getInputNumbers().size()) {
            throw new IllegalArgumentException("게임 실행시 필요한 숫자가 일치하지 않습니다.");
        }
    }
}

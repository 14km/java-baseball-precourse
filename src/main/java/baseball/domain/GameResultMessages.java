package baseball.domain;

import baseball.common.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class GameResultMessages {

    public static String convert(GameResult gameResult) {
        List<String> resultMessagesList = new ArrayList<>();

        if (gameResult.getBallCounter() > 0) {
            resultMessagesList.add(String.format("%d%s", gameResult.getBallCounter(), GameStatus.BALL.getName()));
        }

        if (gameResult.getStrikeCounter() > 0) {
            resultMessagesList.add(String.format("%d%s", gameResult.getStrikeCounter(), GameStatus.STRIKE.getName()));
        }

        if (gameResult.getStrikeCounter() == 0 && gameResult.getBallCounter() == 0) {
            resultMessagesList.add(GameStatus.NOTHING.getName());
        }

        return String.join(" ", resultMessagesList).trim();
    }
}

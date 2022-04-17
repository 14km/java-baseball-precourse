package baseball.controller;

import baseball.common.enums.SystemMessages;
import baseball.common.utils.NumberUtil;
import baseball.domain.*;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private final Player player = new Player();
    private final Computer computer = new Computer();

    public void start() {
        try {
            GameResult gameResult;
            computer.pickNumber();

            do {
                System.out.print(SystemMessages.START.getText());
                player.inputNumber(Console.readLine().trim());

                GameSystem gameSystem = new GameSystem(player, computer);
                gameResult = gameSystem.play();

                System.out.println(GameResultMessages.convert(gameResult));
            } while (gameResult.getStrikeCounter() != GameOption.DRAW_COUNT);

            gameOver();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void gameOver() {
        System.out.println(SystemMessages.GAME_OVER.getText());
        System.out.println(SystemMessages.OPTION.getText());

        String input = Console.readLine().trim();
        if (NumberUtil.isNotNumber(input)) {
            throw new IllegalArgumentException(SystemMessages.OPTION_FAIL.getText());
        }

        if (GameOption.restart(input)) {
            start();
        }
    }
}

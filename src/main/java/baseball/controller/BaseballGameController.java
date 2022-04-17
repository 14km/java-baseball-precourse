package baseball.controller;

import baseball.common.enums.SystemMessages;
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
                // TODO Magic Number 수정
            } while (gameResult.getStrikeCounter() != 3);

            gameOver();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void gameOver() {
        System.out.println(SystemMessages.GAME_OVER.getText());
        System.out.println(SystemMessages.OPTION.getText());

        String input = Console.readLine().trim();

        // TODO Magic Number 수정
        if (input.equals("1")) {
            start();
        }
    }
}

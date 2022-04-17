package baseball.domain;

import baseball.common.enums.SystemMessages;

public class GameOption {
    public static final int DRAW_COUNT = 3;

    private static final String GAME_RESTART = "1";
    private static final String GAME_END = "2";

    public static boolean restart(String input) {
        if (GAME_RESTART.equals(input)) return true;
        if (GAME_END.equals(input)) return false;

        throw new IllegalArgumentException(SystemMessages.OPTION_FAIL.getText());
    }
}

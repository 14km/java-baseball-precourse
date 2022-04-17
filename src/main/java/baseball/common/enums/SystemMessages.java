package baseball.common.enums;

public enum SystemMessages {
    START("숫자를 입력해주세요 : "),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! [게임 종료]"),
    RESULT("게임의 결과 입니다 : "),
    OPTION("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ;

    private final String text;

    SystemMessages(String value) {
        this.text = value;
    }

    public String getText() {
        return text;
    }
}

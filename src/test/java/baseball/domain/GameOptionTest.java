package baseball.domain;

import baseball.common.enums.SystemMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameOptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 게임_재시작_테스트(String input) {
        // given
        // when
        // then
        Assertions.assertThat(GameOption.restart(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2"})
    void 게임_종료_테스트(String input) {
        // given
        // when
        // then
        Assertions.assertThat(GameOption.restart(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "456", "abc"})
    void 잘못된_옵션_선택_테스트(String input) {
        // given
        // when
        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    GameOption.restart(input);
                }).withMessageContaining(SystemMessages.OPTION_FAIL.getText());
    }
}

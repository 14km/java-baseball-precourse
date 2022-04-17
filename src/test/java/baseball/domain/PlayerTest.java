package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    Player player;

    @BeforeEach
    void setting() {
        player = new Player();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "678", "614"})
    void 사용자_숫자입력_테스트(String input) {
        // given
        // when
        player.inputNumber(input);

        // then
        Assertions.assertThat(player.getInputNumbers().size()).isEqualTo(input.length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "dfe", "ede"})
    void 잘못된_문자입력_테스트(String input) {
        // given
        // when
        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    player.inputNumber(input);
                }).withMessageContaining("숫자를 입력해주시기 바랍니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "5678"})
    void 잘못된_숫자길이입력_테스트(String input) {
        // given
        // when
        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    player.inputNumber(input);
                }).withMessageContaining(String.format("숫자는 %s 자리까지 입력이 가능합니다.", GameOption.DRAW_COUNT));
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "222"})
    void 중복된_숫자입력_테스트(String input) {
        // given
        // when
        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    player.inputNumber(input);
                }).withMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }
}

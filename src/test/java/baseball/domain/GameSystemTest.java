package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GameSystemTest {
    List<Integer> computerNumber;

    @BeforeEach
    void setUp() {
        computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void 스트라이크_테스트() {
        // given
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        GameSystem gameSystem = new GameSystem(playerNumber, computerNumber);

        // when
        GameResult gameResult = gameSystem.play();

        // then
        Assertions.assertThat(gameResult.getStrikeCounter()).isEqualTo(3);
    }

    @Test
    @DisplayName("3볼 테스트")
    void 볼_테스트() {
        // given
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(3, 1, 2));

        GameSystem gameSystem = new GameSystem(playerNumber, computerNumber);

        // when
        GameResult gameResult = gameSystem.play();

        // then
        Assertions.assertThat(gameResult.getBallCounter()).isEqualTo(3);
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void 볼테스트_테스트2() {
        // given
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(3, 2, 1));

        GameSystem gameSystem = new GameSystem(playerNumber, computerNumber);

        // when
        GameResult gameResult = gameSystem.play();

        // then
        Assertions.assertThat(gameResult.getBallCounter()).isEqualTo(2);
        Assertions.assertThat(gameResult.getStrikeCounter()).isEqualTo(1);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 낫싱_테스트() {
        // given
        List<Integer> playerNumber = new ArrayList<>(Arrays.asList(4, 5, 6));

        GameSystem gameSystem = new GameSystem(playerNumber, computerNumber);

        // when
        GameResult gameResult = gameSystem.play();

        // then
        Assertions.assertThat(gameResult.getBallCounter()).isEqualTo(0);
        Assertions.assertThat(gameResult.getStrikeCounter()).isEqualTo(0);
    }
}

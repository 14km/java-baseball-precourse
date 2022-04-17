package baseball.domain;

import baseball.common.enums.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 게임결과_등록() {
        // given
        GameResult gameResult = new GameResult();

        // when
        gameResult.addResult(GameStatus.STRIKE);
        gameResult.addResult(GameStatus.STRIKE);
        gameResult.addResult(GameStatus.BALL);

        // then
        Assertions.assertThat(gameResult.getStrikeCounter()).isEqualTo(2);
        Assertions.assertThat(gameResult.getBallCounter()).isEqualTo(1);
    }
}

package baseball.domain;

import baseball.common.enums.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultMessagesTest {

    @Test
    void 결과_메세지_변환_테스트() {
        // given
        GameResult gameResult = new GameResult();
        gameResult.addResult(GameStatus.STRIKE);
        gameResult.addResult(GameStatus.STRIKE);
        gameResult.addResult(GameStatus.BALL);

        // when
        String message = GameResultMessages.convert(gameResult);

        // then
        Assertions.assertThat(message).contains(
                String.format("1%s 2%s", GameStatus.BALL.getName(), GameStatus.STRIKE.getName())
        );
    }

    @Test
    void 낫싱_메세지_반환_테스트() {
        // given
        GameResult gameResult = new GameResult();

        // when
        String message = GameResultMessages.convert(gameResult);

        // then
        Assertions.assertThat(message).contains(GameStatus.NOTHING.getName());
    }
}

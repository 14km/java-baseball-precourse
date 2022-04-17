package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 컴퓨터_숫자_설정() {
        // give
        Computer computer = new Computer();

        // when
        computer.pickNumber();

        // then
        Assertions.assertThat(computer.getRandomsNumbers().size()).isEqualTo(3);
    }
}

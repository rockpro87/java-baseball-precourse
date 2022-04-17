package baseball;

import baseball.config.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"a12", "1234", "112"})
    void 사용자_입력_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작시_잘못된_값_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("831", "3", "2");
                    assertThat(output()).contains("3스트라이크", Message.ERROR_GAME_SIGNAL, "게임 종료");
                },
                8, 3, 1
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

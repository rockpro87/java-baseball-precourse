package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game;
    String answer;

    @BeforeEach
    void beforeAll() {
        game = new Game();
        answer = game.getAnswer();
    }

    @Test
    void 고유한_숫자_확인() {
        HashSet<String> numSet = new HashSet<>(Arrays.asList(answer.split("")));
        assertThat(answer.length()).isEqualTo(numSet.size());
    }
}

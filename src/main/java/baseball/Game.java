package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Game {
    private final String answer;

    public Game() {
        this.answer = getRandomNumber();
    }

    public String getAnswer() {
        return this.answer;
    }

    private String getRandomNumber() {
        LinkedHashSet<Integer> pickNumbers = new LinkedHashSet<>();
        StringBuilder tmpAnswer = new StringBuilder();
        while (pickNumbers.size() < GameConfig.ALL_STRIKE_COUNT.getValue()) {
            pickNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        for (Integer pickNumber : pickNumbers) {
            tmpAnswer.append(pickNumber);
        }
        return tmpAnswer.toString();
    }
}

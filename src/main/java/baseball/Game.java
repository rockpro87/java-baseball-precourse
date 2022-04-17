package baseball;

import baseball.config.Config;
import baseball.config.Message;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Game {
    private final String answer;

    public Game() {
        this.answer = getRandomNumber();
    }

    public boolean isAllStrike(String input) {
        return this.answer.equals(input);
    }

    public String getResultMessage(String input) {
        String validInput = GameUtil.validationInput(input);
        if (isAllStrike(validInput)) {
            return String.format(Message.STRIKE, Config.ALL_STRIKE_COUNT).trim();
        }
        return convertMessage(getCount(validInput));
    }

    private HashMap<String, Integer> getCount(String input) {
        HashMap<String, Integer> countMap = new HashMap<>();
        countMap.put(Config.KEY_STRIKE, getStrikeCount(this.answer, input));
        countMap.put(Config.KEY_BALL, getBallCount(this.answer, input));
        return countMap;
    }

    private String convertMessage(HashMap<String, Integer> countMap) {
        String message = "";
        if (countMap.get(Config.KEY_BALL) > 0) {
            message += String.format(Message.BALL,countMap.get(Config.KEY_BALL));
        }
        if (countMap.get(Config.KEY_STRIKE) > 0) {
            message += String.format(Message.STRIKE,countMap.get(Config.KEY_STRIKE));
        }
        return message.equals("") ? Message.NOTHING : message.trim();
    }

    private int getStrikeCount(String answer, String input) {
        int count = 0;
        for (int i = 0; i < Config.ALL_STRIKE_COUNT; i++) {
            count = count + (answer.charAt(i) == (input.charAt(i)) ? 1 : 0);
        }
        return count;
    }

    private int getBallCount(String answer, String input) {
        int count = 0;
        for (int i = 0; i < Config.ALL_STRIKE_COUNT; i++) {
            count = count + (answer.charAt(i) != (input.charAt(i)) && answer.contains("" + input.charAt(i)) ? 1 : 0);
        }
        return count;
    }

    private String getRandomNumber() {
        LinkedHashSet<Integer> pickNumbers = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();
        while (pickNumbers.size() < Config.ALL_STRIKE_COUNT) {
            pickNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        for (Integer num : pickNumbers) {
            result.append(num);
        }
        return result.toString();
    }
}

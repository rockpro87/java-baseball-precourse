package baseball;

import baseball.config.Config;
import baseball.config.Message;

import java.util.Arrays;
import java.util.HashSet;

public class GameUtil {
    public static String validationInput(String input) {
        allStrikeLength(input);
        uniqueNumber(input);
        onlyNumber(input);
        return input;
    }

    public static void allStrikeLength(String input) {
        if (input.length() != Config.ALL_STRIKE_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_INPUT_LENGTH);
        }
    }

    public static void uniqueNumber(String input) {
        if (input.length() != new HashSet<>(Arrays.asList(input.split(""))).size() ) {
            throw new IllegalArgumentException(Message.ERROR_NOT_UNIQUE);
        }
    }

    public static void onlyNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Message.ERROR_NOT_NUMBER);
        }
    }
}

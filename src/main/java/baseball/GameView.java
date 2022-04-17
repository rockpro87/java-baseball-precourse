package baseball;

import baseball.config.Message;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public static String requestInput() {
        System.out.print(Message.REQUEST_INPUT_NUMBER);
        return Console.readLine();
    }

    public static void result(String message) {
        System.out.println(message);
    }

    public static void clear() {
        System.out.println(Message.GAME_CLEAR);
    }

    public static String waiting() {
        System.out.println(Message.GAME_WAITING);
        return Console.readLine();
    }

    public static void error(String message) {
        System.out.println(message);
    }
}

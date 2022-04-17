package baseball;

import baseball.config.Config;
import baseball.config.Message;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    // 게임 시작
    public static void start() {
        GameController.play(new Game());
    }

    // 게임 진행
    public static void play(Game game) {
        boolean allStrike = false;
        String userInput;
        while (!allStrike) {
            System.out.print(Message.INPUT_NUMBER);
            userInput = Console.readLine();
            System.out.println(game.getResultMessage(userInput));
            allStrike = game.isAllStrike(userInput);
        }
        System.out.println(Message.GAME_CLEAR);
        GameController.stop();
    }

    // 게임 클리어 후 대기
    private static void stop() {
        System.out.println(Message.GAME_WAITING);
        String signal = Console.readLine();
        if (!signal.equals(Config.SIGNAL_START) && !signal.equals(Config.SIGNAL_EXIT)) {
            System.out.println(Message.ERROR_GAME_SIGNAL);
            GameController.stop();
        }
        if (signal.equals(Config.SIGNAL_START)) {
            GameController.start();
        }
    }

}

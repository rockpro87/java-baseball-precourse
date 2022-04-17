package baseball;

import baseball.config.Config;
import baseball.config.Message;
import camp.nextstep.edu.missionutils.Console;

public class Operation {
    // 게임 시작
    public static void start() {
        Operation.progress(new Game());
    }

    // 게임 진행
    private static void progress(Game game) {
        boolean allStrike = false;
        String userInput;
        while (!allStrike) {
            System.out.print(Message.INPUT_NUMBER);
            userInput = Console.readLine();
            allStrike = game.isAllStrike(userInput);
        }
        Operation.stop();
    }

    // 게임 클리어 후 대기
    private static void stop() {
        System.out.println(Message.GAME_CLEAR);
        System.out.println(Message.GAME_WAITING);
        String signal = Console.readLine();
        if (signal.equals(Config.SIGNAL_EXIT) ) {
            Operation.exit();
        } else if (signal.equals(Config.SIGNAL_START)) {
            Operation.start();
        }
        throw new IllegalArgumentException();
    }

    // 완전히 종료
    private static void exit() {
        System.exit(0);
    }
}

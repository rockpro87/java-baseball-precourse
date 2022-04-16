package baseball.opration;

import baseball.GameConfig;
import camp.nextstep.edu.missionutils.Console;

public class Operation {
    // 게임 시작
    public static void start() {
        Operation.progress();
    }

    // 게임 진행
    private static void progress() {
        boolean allStrike = false;
        while (!allStrike) {
            System.out.print(OperationText.INPUT_NUMBER.getText());
            System.out.println(Console.readLine());
            allStrike = true;
        }
        int signal = Operation.stop();
        if (signal == GameConfig.SIGNAL_EXIT.getValue()) {
            Operation.exit();
        } else if (signal == GameConfig.SIGNAL_START.getValue()) {
            Operation.start();
        }
    }

    // 게임 클리어 후 대기
    private static int stop() {
        System.out.println(OperationText.GAME_CLEAR.getText());
        System.out.println(OperationText.GAME_WAITING.getText());
        return Integer.parseInt(Console.readLine());
    }

    // 완전히 종료
    private static void exit() {
        System.exit(0);
    }
}

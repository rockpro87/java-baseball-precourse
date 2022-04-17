package baseball.game;

import baseball.config.Config;
import baseball.config.Message;

public class GameController {
    // 게임 시작
    public static void start() {
        GameController.play(new Game());
    }

    // 게임 진행
    private static void play(Game game) {
        boolean allStrike = false;
        while (!allStrike) {
            String userInput = GameView.requestInput();
            GameView.result(game.getResultMessage(userInput));
            allStrike = game.isAllStrike(userInput);
        }
        GameView.clear();
        GameController.stop();
    }

    // 게임 클리어 후 대기
    private static void stop() {
        String signal = GameView.waiting();
        if (!signal.equals(Config.SIGNAL_START) && !signal.equals(Config.SIGNAL_EXIT)) {
            GameView.error(Message.ERROR_GAME_SIGNAL);
            GameController.stop();
        }
        if (signal.equals(Config.SIGNAL_START)) {
            GameController.start();
        }
    }

}

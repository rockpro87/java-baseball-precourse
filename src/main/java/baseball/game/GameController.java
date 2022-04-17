package baseball.game;

import baseball.config.Config;
import baseball.config.Message;

public class GameController {
    public static void start() {
        GameController.play(new Game());
    }

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

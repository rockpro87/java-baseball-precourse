package baseball.opration;

import baseball.GameConfig;

public enum OperationText {
    INPUT_NUMBER("숫자를 입력해주세요: "),
    GAME_CLEAR(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", GameConfig.ALL_STRIKE_COUNT.getValue())),
    GAME_WAITING(String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            GameConfig.SIGNAL_START.getValue(),
            GameConfig.SIGNAL_EXIT.getValue())
    );

    private final String text;

    OperationText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

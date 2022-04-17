package baseball.config;

public class Message {
    public final static String REQUEST_INPUT_NUMBER = "숫자를 입력해주세요: ";
    public final static String GAME_CLEAR = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Config.ALL_STRIKE_COUNT);
    public final static String GAME_WAITING = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Config.SIGNAL_START, Config.SIGNAL_EXIT);

    public final static String BALL = "%d볼";
    public final static String STRIKE = " %d스트라이크";
    public final static String NOTHING = "낫싱";

    public final static String ERROR_INVALID_INPUT_LENGTH = String.format("%d자리 숫자만 입력가능합니다.", Config.ALL_STRIKE_COUNT);
    public final static String ERROR_NOT_UNIQUE = "동일한 숫자는 입력불가합니다.";
    public final static String ERROR_NOT_NUMBER = "숫자만 입력가능합니다.";
    public final static String ERROR_GAME_SIGNAL = "1 또는 2만 입력가능합니다.";
}

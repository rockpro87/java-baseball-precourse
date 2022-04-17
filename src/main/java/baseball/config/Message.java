package baseball.config;

public class Message {
    public final static String INPUT_NUMBER = "숫자를 입력해주세요: ";
    public final static String GAME_CLEAR = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Config.ALL_STRIKE_COUNT);
    public final static String GAME_WAITING = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Config.SIGNAL_START, Config.SIGNAL_EXIT);
}

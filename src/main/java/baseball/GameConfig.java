package baseball;

public enum GameConfig {
    SIGNAL_START(1),
    SIGNAL_EXIT(2),
    ALL_STRIKE_COUNT(3);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

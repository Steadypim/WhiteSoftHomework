package dev.steadypim.homework1.game.guessingGame;

public enum GuessingGameNumberConstraints {
    MIN_NUMBER(1),
    MAX_NUMBER(10);

    private final int value;

    GuessingGameNumberConstraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

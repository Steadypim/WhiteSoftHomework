package dev.steadypim.homework1.game.guessingGame;

/**
 * Интерфейс игры угадай число
 */
public interface GuessingGameService {
    int getRandomNumber(int min, int max);

    int getGuessedNumber();

    void handleIncorrectGuess(int guessedNumber, int correctNumber);
}

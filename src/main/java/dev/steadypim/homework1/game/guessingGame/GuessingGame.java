package dev.steadypim.homework1.game.guessingGame;
/**
 * Игра угадай число
 */
public class GuessingGame{

    private final GuessingGameServiceImpl gameService = new GuessingGameServiceImpl();
    public void start() {
        gameService.start();
    }
}

package dev.steadypim.homework1;

import dev.steadypim.homework1.game.guessingGame.GuessingGame;
public class App {
    public static void main(String[] args) {
        GuessingGame guessingGame = new GuessingGame();
        guessingGame.start();
    }
}
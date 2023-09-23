package dev.steadypim.homework1.game.guessingGame;

import dev.steadypim.homework1.game.Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Реализация логики игры угадай число
 */
public class GuessingGameServiceImpl implements GuessingGameService, Game {

    private static final int MAX_NUMBER = GuessingGameNumberConstraints.MAX_NUMBER.getValue();
    private static final int MIN_NUMBER = GuessingGameNumberConstraints.MIN_NUMBER.getValue();

    private Scanner scanner;
    private final Random random;

    public GuessingGameServiceImpl() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public int getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public int getGuessedNumber() {
        int number;

        while (true) {
            try {
                number = scanner.nextInt();
                if (number < MIN_NUMBER || number > MAX_NUMBER) {
                    System.out.println("Читать не умеешь?");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Я же просил число! Ладно, попробуй еще раз");
                scanner.nextLine();
            }
        }

        return number;
    }

    public void handleIncorrectGuess(int guessedNumber, int correctNumber) {
        int difference = Math.abs(guessedNumber - correctNumber);

        if (difference > 5) {
            System.out.println("Холодно");
        } else if (difference > 2) {
            System.out.println("Тепло");
        } else {
            System.out.println("Жгётся!");
        }
    }

    public void start() {
        System.out.println("Привет!\nБудешь угадывать? (да/нет)");
        String answer = scanner.nextLine();
        if (answer.equals("нет")) {
            System.out.println("(×﹏×)");
            return;
        } else if (!answer.equals("да")) {
            System.out.println("(︶︹︺)\nНепонятно, давай до свидания");
            return;
        }

        System.out.println("(⌒‿⌒)");

        while (true) {
            int randomNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            System.out.println("Угадай число от " + MIN_NUMBER + " до " + MAX_NUMBER);

            while (true) {
                int guessedNumber = getGuessedNumber();

                if (guessedNumber == randomNumber) {
                    System.out.println("╰(▔∀▔)╯");
                    System.out.println("Будешь угадывать? (да/нет)");
                    scanner = new Scanner(System.in);
                    answer = scanner.nextLine();
                    if (answer.equals("нет")) {
                        System.out.println("(¬_¬ )");
                        return;
                    } else if (!answer.equals("да")) {
                        System.out.println("(︶︹︺)\nНепонятно. Давай, до свидания!");
                        return;
                    }
                    System.out.println("(⌒‿⌒)");
                    break;
                } else {
                    handleIncorrectGuess(guessedNumber, randomNumber);
                }
            }
        }
    }
}

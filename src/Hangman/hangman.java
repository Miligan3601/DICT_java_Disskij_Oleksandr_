package Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("HANGMAN");
        System.out.println("The game will be available soon.");

        System.out.println("HANGMAN");
        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        String targetWord = "java";

        System.out.print("Guess the word: > ");
        String guessedWord = scanner.nextLine().trim();

        if (guessedWord.equalsIgnoreCase(targetWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        System.out.println("HANGMAN");
        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        String[] wordList = {"python", "java", "javascript", "kotlin"};
        String targetWordFromList = wordList[random.nextInt(wordList.length)];
        int maxAttempts = 8;

        StringBuilder guessedWordFromList = new StringBuilder("_".repeat(targetWordFromList.length()));
        int attemptsLeft = maxAttempts;

        while (attemptsLeft > 0) {
            System.out.println("Guess the word: " + guessedWordFromList);
            System.out.println("Attempts left: " + attemptsLeft);

            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase(targetWordFromList)) {
                System.out.println("You survived!");
                break;
            } else {
                System.out.println("You lost!");
                break;
            }
        }
    }
}

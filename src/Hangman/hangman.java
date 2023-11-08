package Hangman;

import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("Вітаємо у грі 'Шибениця'!");
        System.out.println("Гра буде доступна незабаром.");

        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String targetWord = words[random.nextInt(words.length)];
        String maskedWord = targetWord.substring(0, 2) + "-".repeat(targetWord.length() - 2);
        int attempts = 8;

        while (attempts > 0) {
            System.out.println("Guess the word: " + maskedWord);
            System.out.println("Attempts left: " + attempts);

            String guessedLetter = scanner.nextLine();

            if (guessedLetter.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char letter = guessedLetter.charAt(0);

            if (targetWord.contains(String.valueOf(letter))) {
                StringBuilder newMaskedWord = new StringBuilder(maskedWord);
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == letter) {
                        newMaskedWord.setCharAt(i, letter);
                    }
                }
                maskedWord = newMaskedWord.toString();
                if (!maskedWord.contains("-")) {
                    System.out.println("You survived!");
                    break;
                }
            } else {
                System.out.println("Incorrect letter.");
                attempts--;
            }
        }

        if (attempts == 0) {
            System.out.println("You lost!");
        }
    }
}

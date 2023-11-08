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
        StringBuilder maskedWord = new StringBuilder("-".repeat(targetWord.length()));
        int attempts = 8;

        while (attempts > 0) {
            System.out.println(maskedWord);
            System.out.println("Input a letter: > ");
            String guessedLetter = scanner.nextLine();

            if (guessedLetter.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char letter = guessedLetter.charAt(0);

            if (targetWord.contains(String.valueOf(letter))) {
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == letter) {
                        maskedWord.setCharAt(i, letter);
                    }
                }
                if (!maskedWord.toString().contains("-")) {
                    System.out.println(maskedWord);
                    System.out.println("Thanks for playing!");
                    System.out.println("We'll see how well you did in the next stage");
                    break;
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                attempts--;
            }
        }

        if (attempts == 0) {
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
        }
    }
}

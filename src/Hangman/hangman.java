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
        int attemptsLeft = 8;
        boolean[] guessedLetters = new boolean[26];

        while (attemptsLeft > 0) {
            System.out.println(maskedWord);
            System.out.println("Input a letter: > ");
            String guessedLetter = scanner.nextLine();

            if (guessedLetter.length() != 1 || !Character.isLetter(guessedLetter.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char letter = guessedLetter.charAt(0);

            if (guessedLetters[letter - 'a']) {
                System.out.println("No improvements");
            } else if (targetWord.contains(String.valueOf(letter))) {
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == letter) {
                        maskedWord.setCharAt(i, letter);
                    }
                }
                guessedLetters[letter - 'a'] = true;
                if (!maskedWord.toString().contains("-")) {
                    System.out.println(maskedWord);
                    System.out.println("You guessed the word!");
                    System.out.println("You survived!");
                    break;
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                attemptsLeft--;
                guessedLetters[letter - 'a'] = true;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("You lost!");
        }
    }
}

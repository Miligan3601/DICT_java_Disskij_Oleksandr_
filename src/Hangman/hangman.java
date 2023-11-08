package Hangman;

import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();

        boolean playGame = true;

        while (playGame) {
            System.out.println("HANGMAN");
            System.out.println("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.nextLine();

            if (choice.equals("play")) {
                String targetWord = words[random.nextInt(words.length)];
                StringBuilder maskedWord = new StringBuilder("-".repeat(targetWord.length()));
                int attemptsLeft = 8;
                boolean[] guessedLetters = new boolean[26];

                while (attemptsLeft > 0) {
                    System.out.println(maskedWord);
                    System.out.print("Input a letter: > ");
                    String guessedLetter = scanner.nextLine();

                    if (guessedLetter.length() != 1 || !Character.isLetter(guessedLetter.charAt(0))) {
                        System.out.println("Please enter a single lowercase English letter.");
                        continue;
                    }

                    char letter = guessedLetter.charAt(0);

                    if (guessedLetters[letter - 'a']) {
                        System.out.println("You've already guessed this letter");
                    } else if (targetWord.contains(String.valueOf(letter))) {
                        for (int i = 0; i < targetWord.length(); i++) {
                            if (targetWord.charAt(i) == letter) {
                                maskedWord.setCharAt(i, letter);
                            }
                        }
                        guessedLetters[letter - 'a'] = true;
                        if (!maskedWord.toString().contains("-")) {
                            System.out.println(maskedWord);
                            System.out.println("You guessed the word " + targetWord + "!");
                            System.out.println("You survived!");
                            break;
                        }
                    } else {
                        System.out.println("That letter doesn't appear in the word");
                        guessedLetters[letter - 'a'] = true;
                        attemptsLeft--;
                    }
                }

                if (attemptsLeft == 0) {
                    System.out.println("You lost!");
                }
            } else if (choice.equals("exit")) {
                playGame = false;
            } else {
                System.out.println("Invalid choice. Please enter \"play\" to play the game or \"exit\" to quit.");
            }
        }
    }
}

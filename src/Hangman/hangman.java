package Hangman;

import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("Вітаємо у грі 'Шибениця'!");
        System.out.println("Гра буде доступна незабаром.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the word: > ");
        String guessedWord = scanner.nextLine().trim();

        String targetWord = "java";

        if (guessedWord.equalsIgnoreCase(targetWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}

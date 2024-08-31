Import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        int LIVES = 9;
        ArrayList<Character> incorrectGuesses = new ArrayList<>();
        String[] words = new String[]{"words you can geuss", "For example", "apple sauce"};
        Scanner scanner = new Scanner(System.in);
        String answer = words[(int)(Math.random() * words.length)];
        char[] wordStatus = new char[answer.length() * 2]; // Array to store _ and spaces

        // Initialize wordStatus with '_ ' for letters and ' ' for spaces
        for (int i = 0; i < answer.length(); i++) {
 
            wordStatus[i * 2] = (answer.charAt(i) == ' ') ? ' ' : '_';
           
            if (i * 2 + 1 < wordStatus.length) {
                wordStatus[i * 2 + 1] = ' ';  // Insert a space after each position
            }
        }

        System.out.println("Welcome to Hangman!");


        do {
            System.out.println("Word status: " + new String(wordStatus));
            System.out.print("Enter a guess: ");
            String userInput = scanner.nextLine().toLowerCase();

            // Check for valid input (single character only)
            if (userInput.length() != 1) {
                System.out.println("Please enter a single character.");
                continue;
            }

            char guess = userInput.charAt(0);

            if (answer.contains(userInput)) {
                wordStatus = checkLetter(guess, wordStatus, answer);
            } else {
                LIVES--;
                incorrectGuesses.add(guess);
                System.out.println("\nWrong. You only have " + LIVES + " lives left...");
            }

            // Display incorrect guesses
            System.out.println("\nIncorrect guesses: " + incorrectGuesses);
        } while (LIVES > 0 && new String(wordStatus).contains("_"));

        if (!new String(wordStatus).contains("_")) {
            System.out.println("Woohoo! You won! You thought of the word " + answer);
        } else {
            System.out.println("Boooo! You lost. How did you not think of the word " + answer);
        }
    }

    // Method Goes Through the Word and answer and high;ight geussed letters if found
    private static char[] checkLetter(char guess, char[] wordStatus, String answer) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                wordStatus[i * 2] = guess; // Update every second position for the letter (skip the space)
            }
        }
        return wordStatus;
    }
}

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        // Generate a random number between 1 and 100
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;

        // Initialize the number of attempts
        int attempts = 0;

        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (true) {

            // Ask the user for their guess
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            attempts++;

            // Check if the user's guess is correct
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in "
                        + attempts + " attempts.");
                break;
            }
            else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            }
            else {
                System.out.println("Too high! Try again.");
            }
        }

        scanner.close();
    }
}

import java.util.Scanner;
import java.util.Random;

public class Nu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        // Specify the range for the random number
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Specify the maximum number of attempts
        int maxAttempts = 5;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.printf("I have selected a number between %d and %d.%n", lowerBound, upperBound);
        System.out.printf("You have %d attempts to guess it.%n", maxAttempts);

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int playerGuess;

            // Validate user input
            if (scanner.hasNextInt()) {
                playerGuess = scanner.nextInt();
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // Clear invalid input
                continue;
            }

            attempts++;

            if (playerGuess == randomNumber) {
                System.out.printf("Congratulations! You've guessed the number in %d attempts.%n", attempts);
                guessedCorrectly = true;
                break;
            } else if (playerGuess < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            System.out.printf("You have %d attempts left.%n", maxAttempts - attempts);
        }

        if (!guessedCorrectly) {
            System.out.printf("Sorry, you've used all your attempts. The correct number was %d.%n", randomNumber);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

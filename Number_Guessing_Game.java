import java.util.Random;
import java.util.Scanner;

class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10; // Maximum number of attempts allowed per round
    private static final int MAX_ROUNDS = 3;    // Number of rounds in the game
    private static final int RANGE_START = 1;   // Start of the range for random number
    private static final int RANGE_END = 100;   // End of the range for random number

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round + " - Guess the number between " + RANGE_START + " and " + RANGE_END);

            while (attempts < MAX_ATTEMPTS && !guessed) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number.");
                    guessed = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            int points = guessed ? (MAX_ATTEMPTS - attempts + 1) : 0;
            totalScore += points;

            if (!guessed) {
                System.out.println("You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Round " + round + " score: " + points);
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
    }
}

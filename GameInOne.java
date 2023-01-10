import java.util.Random;
import java.util.Scanner;

public class GameInOne {

    public static void main(String[] args) {
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Initialize scores for both players
        int player1Score = 0;
        int player2Score = 0;

        // Run the game loop
        while (true) {
            // Generate a random pile size between 10 and 50, inclusive
            Random random = new Random();
            int pileSize = random.nextInt(41) + 10;

            // Get the names of the players
            System.out.print("Player 1 name: ");
            String player1Name = scanner.nextLine();
            System.out.print("Player 2 name: ");
            String player2Name = scanner.nextLine();

            // Choose the first player at random
            String currentPlayerName;
            if (random.nextInt(2) == 0) {
                currentPlayerName = player1Name;
            } else {
                currentPlayerName = player2Name;
            }

            // Run the turn-based loop until the pile is empty or there is only one piece left
            while (pileSize > 1) {
                System.out.println(currentPlayerName + ", the current pile size is " + pileSize + ".");
                System.out.print("Enter the number of pieces to take: ");
                int piecesToTake = scanner.nextInt();

                // Validate the input
                if (piecesToTake < 1 || piecesToTake > (pileSize / 2)) {
                    System.out.println("Invalid input. Please try again. Remeber, you cannot take more than half the pile at any given time");
                    continue;
                }

                // Remove the pieces from the pile
                pileSize -= piecesToTake;

                // Switch players
                if (currentPlayerName.equals(player1Name)) {
                    currentPlayerName = player2Name;
                } else {
                    currentPlayerName = player1Name;
                }
            }

            // Announce the winner and update the score
            if (currentPlayerName.equals(player1Name)) {
                System.out.println(player2Name + " wins!");
                player2Score++;
            } else {
                System.out.println(player1Name + " wins!");
                player1Score++;
            }

            // Print the scores
            System.out.println("Scores: " + player1Name + " " + player1Score + ", " + player2Name + " " + player2Score);

            // Ask if the players want to play again
            System.out.print("Play again? Please respond, Y for yes, N for no) ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("Y")) {
                break;
            }
        }
        scanner.close();
    } 
}
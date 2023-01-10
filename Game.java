
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Initialize scores for both players
        int player1Score = 0;
        int player2Score = 0;

        // Create an instance of the Board class
        Board board = new Board();

        // Create a Random object
        Random random = new Random();


        // Run the game loop
        while (true) {
            // Populate the board
            board.populate();

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

            // Run the round loop
            while (board.getCount() > 1) {
                // Print the current state of the board
                System.out.println("Number of pieces remaining: " + board.getCount());

                // Prompt the current player to take their turn
                System.out.print(currentPlayerName + ", enter the number of pieces you want to remove: ");
                int numPieces = scanner.nextInt();

                // Validate the input
                if (numPieces < 1 || numPieces > board.getCount() / 2) {
                    System.out.println("Invalid input! Remember, you cannot remove more than half of the pile at any given time. Please try again.");
                    continue;
                }

                // Remove the pieces from the board
                board.takePiece(numPieces);

                // Switch players
                if (currentPlayerName.equals(player1Name)) {
                    currentPlayerName = player2Name;
                } else {
                    currentPlayerName = player1Name;
                }
            }

            // Announce the winner
            if (currentPlayerName.equals(player1Name)) {
                System.out.println(player2Name + " wins!");
                player2Score++;
            } else {
                System.out.println(player1Name + " wins!");
                player1Score++;
            }

            // Print the scores
            System.out.println(player1Name + ": " + player1Score + " points");
            System.out.println(player2Name + ": " + player2Score + " points");

            // Ask the player if they want to play again
            System.out.print("Do you want to play again? (y/n) ");
            String input = scanner.next();

            if (!input.equalsIgnoreCase("y")) {
                break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}

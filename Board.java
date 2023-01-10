
import java.util.Random;

public class Board {
    private int pieces;

    public void populate() {
        // Generate a random pile size between 10 and 50, inclusive
        Random random = new Random();
        pieces = random.nextInt(41) + 10;
    }

    public int getCount() {
        return pieces;
    }

    public void takePiece(int numPieces) {
        pieces -= numPieces;
    }
}

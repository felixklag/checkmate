import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player currentPlayer;
        Player opponentPlayer;
        Move currentMove;
        Scanner scanner = new Scanner(System.in);

        boolean running = true;


        Board board = new Board();

        Player player_white = new Player(true);
        Player player_black = new Player(false);

        // Init
        currentPlayer = player_white;
        opponentPlayer = player_black;

        while (running) {
            // Print Board
            board.printBoard();

            // Debug Print Possible Moves
            System.out.println(Arrays.toString(board.getPossibleMoves(currentPlayer).toArray()));

            // Make Move
            currentMove = new Move(board, currentPlayer, scanner);

            // Switch Players
            if (currentPlayer.isWhite()) {
                currentPlayer = player_black;
                opponentPlayer = player_white;
            } else {
                currentPlayer = player_white;
                opponentPlayer = player_black;
            }

            // Check Game Over
            if (board.checkMate(currentPlayer, opponentPlayer)) {
                running = false;
                board.printBoard();
                System.out.println("Game Over!");
            }
        }
    }
}
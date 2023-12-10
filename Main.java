import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player currentPlayer;
        Move currentMove;
        Scanner scanner = new Scanner(System.in);

        boolean running = true;


        Board board = new Board();

        Player player_white = new Player(true);
        Player player_black = new Player(false);

        // Init
        currentPlayer = player_white;
        board.printBoard();
        List<String> test = board.getPossibleMoves(currentPlayer);
        System.out.println(Arrays.toString(test.toArray()));

        // Game
//        while(running) {
//            board.printBoard();
//            currentMove = currentPlayer.makeMove(board, scanner);
//            // Check if game over
//            if (currentPlayer.isWhite()) {
//                currentPlayer = player_black;
//            } else {
//                currentPlayer = player_white;
//            }
//        }
        board.printBoard();

    }
}
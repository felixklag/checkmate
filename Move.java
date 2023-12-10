import java.util.List;
import java.util.Scanner;

public class Move {
    private boolean white;
    private C startPos;
    private C endPos;
    private Piece piece;

    public Move(Board board, Player player, Scanner scanner) {
        this.white = player.isWhite();
        startPos = new C(0, 0);
        endPos = new C(0, 0);

        if(white) {
            System.out.println("Current Player: White");
        } else {
            System.out.println("Current Player: Black");
        }

        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter Move: ");
            String command = scanner.nextLine();

            if (inputValid(command)) {
                List<String> moves = board.getPossibleMoves(player);

                if (moves.contains(command)) {
                    // Set internal position
                    set(parse(command));

                    // Check if enemy piece is taken
                    Piece enemy = board.getPiece(endPos);
                    if (enemy != null) {
                        board.getPieces().remove(enemy);
                    }

                    // Move piece
                    piece = board.getPiece(startPos);
                    piece.setPos(endPos);

                    isValid = true;
                } else {
                    System.out.println("This is not a valid move!");
                }
            }
        }
    }

    private void set(int[] pos) {
        startPos.setX(pos[0]);
        startPos.setY(pos[1]);
        endPos.setX(pos[2]);
        endPos.setY(pos[3]);
    }

    private boolean isMovable(Board board) {
        this.piece = board.getPiece(startPos);
        if (piece == null) {
            System.out.println("No piece on specified spot!");
            return false;
        }
        if (piece.isWhite() != white) {
            System.out.println("This is not your piece!");
            return false;
        }
        return true;
    }

    private boolean inputValid(String command) {
        if (command.length() != 4
                || !Character.isLetter(command.charAt(0))
                || !Character.isDigit(command.charAt(1))
                || !Character.isLetter(command.charAt(2))
                || !Character.isDigit(command.charAt(3))) {
            System.out.println("Input is needed in Form: a1b2");
            return false;
        }
        return true;
    }

    private int[] parse(String command) {
        int[] out = new int[4];

        out[1] = command.charAt(0) - 'a';
        out[0] = Character.getNumericValue(command.charAt(1)) - 1;
        out[3] = command.charAt(2) - 'a';
        out[2] = Character.getNumericValue(command.charAt(3)) - 1;

        return out;
    }
}

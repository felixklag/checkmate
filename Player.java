import java.util.Scanner;

public class Player {
    private final boolean white;


    public Player(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public Move makeMove(Board board, Scanner scanner) {
        return new Move(white, board, scanner);
    }


}

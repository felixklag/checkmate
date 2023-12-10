import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public List<C> getPossibleMoves(Board board) {
        List<C> moves = new ArrayList<C>();
        C toAdd;
        boolean reachedObstacle ;

        // +y -> right side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(0, 1);

            // Check other pieces in way
            for (Piece piece : board.getPieces()) {
                if (piece.getPos().isSame(toAdd)) {
                    if (piece.isWhite() != isWhite()) {
                        moves.add(toAdd);
                    }
                    reachedObstacle = true;
                }
            }

            // Check out of bounds
            if (toAdd.getY() > 7) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        // -y -> left side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(0, -1);

            // Check other pieces in way
            for (Piece piece : board.getPieces()) {
                if (piece.getPos().isSame(toAdd)) {
                    if (piece.isWhite() != isWhite()) {
                        moves.add(toAdd);
                    }
                    reachedObstacle = true;
                }
            }

            // Check out of bounds
            if (toAdd.getY() < 0) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        // +x -> bottom side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(1, 0);

            // Check other pieces in way
            for (Piece piece : board.getPieces()) {
                if (piece.getPos().isSame(toAdd)) {
                    if (piece.isWhite() != isWhite()) {
                        moves.add(toAdd);
                    }
                    reachedObstacle = true;
                }
            }

            // Check out of bounds
            if (toAdd.getX() > 7) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        // -x -> top side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(-1, 0);

            // Check other pieces in way
            for (Piece piece : board.getPieces()) {
                if (piece.getPos().isSame(toAdd)) {
                    if (piece.isWhite() != isWhite()) {
                        moves.add(toAdd);
                    }
                    reachedObstacle = true;
                }
            }

            // Check out of bounds
            if (toAdd.getX() < 0) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        return moves;
    }

    public char getChar() {
        return 'R';
    }
}

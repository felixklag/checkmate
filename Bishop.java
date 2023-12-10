import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public List<C> getPossibleMoves(Board board) {
        List<C> moves = new ArrayList<C>();
        C toAdd;
        boolean reachedObstacle ;

        // +y +x -> right bottom side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(1, 1);

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
            if (toAdd.getY() > 7 || toAdd.getX() > 7) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        // -y +x -> left bottom side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(1, -1);

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
            if (toAdd.getY() < 0 || toAdd.getX() > 7) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        // +y -x -> right top side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(-1, 1);

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
            if (toAdd.getY() > 7 || toAdd.getX() < 0) {
                reachedObstacle = true;
            }

            // Add Move
            if (!reachedObstacle) {
                moves.add(toAdd);
            }
        }

        // -y -x -> left top side
        toAdd = getPos();
        reachedObstacle = false;
        while (!reachedObstacle) {
            toAdd = new C(toAdd).addr(-1, -1);

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
            if (toAdd.getY() < 0 || toAdd.getX() < 0) {
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
        return 'B';
    }
}

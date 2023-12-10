import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public List<C> getPossibleMoves(Board board) {
        List<C> moves = new ArrayList<C>();
        if (super.isWhite()) { //todo add going 2 places
            moves.add(new C(super.getPos()).addr(1, 0));
        } else {
            moves.add(new C(super.getPos()).addr(-1, 0));
        }

        super.removeOutOfBounds(moves);

        List<C> movesToRemove = new ArrayList<>();
        for (C c : moves) {
            for (Piece piece : board.getPieces()) {
                if (c.getX() == piece.getPos().getX()
                        && c.getY() == piece.getPos().getY()) {
                    movesToRemove.add(c);
                }
            }
        }
        moves.removeAll(movesToRemove);

        if (super.isWhite()) {
            for (Piece piece : board.getPieces()) {
                if ((super.getPos().getX() + 1) == piece.getPos().getX()
                        && (super.getPos().getY() + 1) == piece.getPos().getY()
                        && !piece.isWhite()) {
                    moves.add(new C(piece.getPos()));
                }
                if ((super.getPos().getX() + 1) == piece.getPos().getX()
                        && (super.getPos().getY() - 1) == piece.getPos().getY()
                        && !piece.isWhite()) {
                    moves.add(new C(piece.getPos()));
                }
            }
        } else {
            for (Piece piece : board.getPieces()) {
                if ((super.getPos().getX() - 1) == piece.getPos().getX()
                        && (super.getPos().getY() + 1) == piece.getPos().getY()
                        && piece.isWhite()) {
                    moves.add(new C(piece.getPos()));
                }
                if ((super.getPos().getX() - 1) == piece.getPos().getX()
                        && (super.getPos().getY() - 1) == piece.getPos().getY()
                        && piece.isWhite()) {
                    moves.add(new C(piece.getPos()));
                }
            }
        }
        return moves;
    }

    public char getChar() {
        return 'p';
    }
}

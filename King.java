import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public List<C> getPossibleMoves(Board board) {
        List<C> moves = new ArrayList<C>();

        moves.add(new C(super.getPos()).addr(0, 1));
        moves.add(new C(super.getPos()).addr(1, 1));
        moves.add(new C(super.getPos()).addr(1, 0));
        moves.add(new C(super.getPos()).addr(1, -1));
        moves.add(new C(super.getPos()).addr(0, -1));
        moves.add(new C(super.getPos()).addr(-1, -1));
        moves.add(new C(super.getPos()).addr(-1, 0));
        moves.add(new C(super.getPos()).addr(-1, 1));

        super.removeOutOfBounds(moves);

        List<C> movesToRemove = new ArrayList<>();
        for (C c : moves) {
            for (Piece piece : board.getPieces()) {
                if (c.getX() == piece.getPos().getX()
                        && c.getY() == piece.getPos().getY()
                        && super.isWhite() == piece.isWhite()) {
                    movesToRemove.add(c);
                }
            }
        }
        moves.removeAll(movesToRemove);

        return moves;
    }

    public char getChar() {
        return 'K';
    }
}

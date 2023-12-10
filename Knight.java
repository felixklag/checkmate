import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public List<C> getPossibleMoves(Board board) {
        List<C> moves = new ArrayList<C>();

        moves.add(new C(super.getPos()).addr(2, 1));
        moves.add(new C(super.getPos()).addr(2, -1));
        moves.add(new C(super.getPos()).addr(1, 2));
        moves.add(new C(super.getPos()).addr(1, -2));
        moves.add(new C(super.getPos()).addr(-1, 2));
        moves.add(new C(super.getPos()).addr(-1, -2));
        moves.add(new C(super.getPos()).addr(-2, 1));
        moves.add(new C(super.getPos()).addr(-2, -1));

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
        return 'N';
    }
}

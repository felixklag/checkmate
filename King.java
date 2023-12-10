import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public List<C> getPossibleMoves(Board board) {
        List<C> moves = getPossibleMovesWOCheck(board);
        List<C> movesToRemove = new ArrayList<>();

        // Check for check
        // Init Pos
        C initPos = getPos();

        // Check for every move the King can make if someone can take the King
        for (C move : moves) {
            setPos(move);

            // Get moves of Opponent
            for (Piece oppPiece : board.getPieces()) {
                if (oppPiece.isWhite() != isWhite()
                    && oppPiece.getChar() != 'K') {
                    List<C> oppPieceMoves = oppPiece.getPossibleMoves(board);
                    for (C c : oppPieceMoves) {
                        if (getPos().isSame(c)) {
                            movesToRemove.add(move);
                        }
                    }
                } else if (oppPiece.isWhite() != isWhite()
                        && oppPiece.getChar() == 'K') {
                    List<C> oppPieceMoves = ((King) oppPiece).getPossibleMovesWOCheck(board);
                    for (C c : oppPieceMoves) {
                        if (getPos().isSame(c)) {
                            movesToRemove.add(move);
                        }
                    }
                }
            }
        }
        // Reset Position
        setPos(initPos);

        moves.removeAll(movesToRemove);

        return moves;
    }

    private List<C> getPossibleMovesWOCheck (Board board) {
        List<C> moves = new ArrayList<C>();

        // Allowed moves
        moves.add(new C(super.getPos()).addr(0, 1));
        moves.add(new C(super.getPos()).addr(1, 1));
        moves.add(new C(super.getPos()).addr(1, 0));
        moves.add(new C(super.getPos()).addr(1, -1));
        moves.add(new C(super.getPos()).addr(0, -1));
        moves.add(new C(super.getPos()).addr(-1, -1));
        moves.add(new C(super.getPos()).addr(-1, 0));
        moves.add(new C(super.getPos()).addr(-1, 1));

        // Remove out of Bounds
        super.removeOutOfBounds(moves);

        // Remove going to same spot allied piece is
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

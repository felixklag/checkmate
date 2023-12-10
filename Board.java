import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private final boolean WHITE = true;
    private final boolean BLACK = false;

    private List<Piece> pieces = new ArrayList<>();

    public Board() {
        pieces.add(new Rook(WHITE, new C(0, 0), this));
        pieces.add(new Knight(WHITE, new C(0, 1), this));
        pieces.add(new Bishop(WHITE, new C(0, 2), this));
        pieces.add(new Queen(WHITE, new C(0, 3), this));
        pieces.add(new King(WHITE, new C(2, 4), this));
        pieces.add(new Bishop(WHITE, new C(0, 5), this));
        pieces.add(new Knight(WHITE, new C(0, 6), this));
        pieces.add(new Rook(WHITE, new C(0, 7), this));

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(WHITE, new C(1, i), this));
        }
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(BLACK, new C(6, i), this));
        }

        pieces.add(new Rook(BLACK, new C(7, 0), this));
        pieces.add(new Knight(BLACK, new C(7, 1), this));
        pieces.add(new Bishop(BLACK, new C(7, 2), this));
        pieces.add(new Queen(BLACK, new C(7, 3), this));
        pieces.add(new King(BLACK, new C(3, 4), this));
        pieces.add(new Bishop(BLACK, new C(7, 5), this));
        pieces.add(new Knight(BLACK, new C(7, 6), this));
        pieces.add(new Rook(BLACK, new C(7, 7), this));
    }
    public List<Piece> getPieces() {
        return pieces;
    }

    public void move(C fromPos, C toPos) {
        for (Piece piece : pieces) {
            if (piece.getPos() == fromPos) {
                piece.setPos(toPos);
            }
        }
    }

    public List<String> getPossibleMoves(Player player) {
        List<String> moves = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.isWhite() == player.isWhite()) {
                List<C> pieceMoves = piece.getPossibleMoves(this);
                for (C c : pieceMoves) {
                    moves.add(C2String(piece.getPos(), c));
                }
            }
        }
        return moves;
    }

    public void printBoard() {
        boolean set;
        System.out.println(ANSI_RESET + "   a b c d e f g h");

        for (int i = 0; i < 8; i++) {
            System.out.print(ANSI_RESET + (i+1) + "  ");
            for (int j = 0; j < 8; j++) {
                set = false;
                for (Piece piece : pieces) {
                    if (piece.getPos().getX() == i && piece.getPos().getY() == j) {
                        set = true;
                        if (piece.isWhite()){
                            System.out.print(ANSI_BLUE + piece.getChar() + " ");
                        } else {
                            System.out.print(ANSI_RED + piece.getChar() + " ");
                        }
                    }
                }
                if (!set) {
                    System.out.print(ANSI_RESET + "." + " ");
                }
            }
            System.out.println(ANSI_RESET + " " + (i+1));
        }
        System.out.println(ANSI_RESET + "   a b c d e f g h");
    }

    private String C2String(C start, C end) {
        char x1 = (char) (start.getX() + '1');
        char y1 = (char) (start.getY() + 'a');
        char x2 = (char) (end.getX() + '1');
        char y2 = (char) (end.getY() + 'a');

        return "" + y1 + x1 + y2 + x2;
    }

    public Piece getPiece(C pos) {
        for (Piece piece : pieces) {
            if (piece.getPos() == pos) {
                return piece;
            }
        }
        return null;
    }
}

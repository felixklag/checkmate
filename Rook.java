public class Rook extends Piece{
    public Rook(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public char getChar() {
        return 'R';
    }
}

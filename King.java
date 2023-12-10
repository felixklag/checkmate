public class King extends Piece{
    public King(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public char getChar() {
        return 'K';
    }
}

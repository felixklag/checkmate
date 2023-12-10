public class Queen extends Piece{
    public Queen(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public char getChar() {
        return 'Q';
    }
}

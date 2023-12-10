public class Bishop extends Piece{
    public Bishop(boolean white, C pos, Board board) {
        super(white, pos, board);
    }

    public char getChar() {
        return 'B';
    }
}

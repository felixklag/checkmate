import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private final boolean white;
    private C pos;
    private Board board;

    public Piece(boolean white, C pos, Board board) {
        this.white = white;
        this.pos = pos;
        this.board = board;
    }

    public List<C> getPossibleMoves(Board board) {
        return new ArrayList<C>();
    }

    public void removeOutOfBounds(List<C> in) {
        in.removeIf(c -> c.getX() < 0
                || c.getY() < 0
                || c.getX() > 7
                || c.getY() > 7);
        //return new ArrayList<C>();
    }

    public boolean isWhite() {
        return white;
    }

    public C getPos() {
        return pos;
    }

    public void setPos(C pos) {
        this.pos = pos;
    }

    public char getChar() {
        return 'x';
    }


}

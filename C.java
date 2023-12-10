public class C {
    private int x;
    private int y;

    public C(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public C(C ref) {
        this.x = ref.getX();
        this.y = ref.getY();
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public C addr(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public boolean isSame(C c) {
        return this.getX() == c.getX() && this.getY() == c.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
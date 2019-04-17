public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void incrementX() {
        x =x+1;
    }

    public void decrementX() {
        x =x-1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementY() {
        y=y+1;
    }

    public void decrementY() {
        y =y-1;
    }
}

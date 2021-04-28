package abstractclass.gamecharacter;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long distance(Point otherPoint) {
        return (long) Math.sqrt(
                Math.pow((double)x - otherPoint.getX(), 2) +
                        Math.pow((double)y - otherPoint.getY(), 2)
        );
    }
}

package tads;

public class Coord {
    public int x, y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        return x == ((Coord) other).x && y == ((Coord) other).y;
    }
}
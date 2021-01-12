package main;

// make the point structure
public class Point {
    private int number;
    private boolean wasGot;

    public Point(int number, boolean wasGot) {
        this.number = number;
        this.wasGot = wasGot;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWasGot() {
        return wasGot;
    }
}

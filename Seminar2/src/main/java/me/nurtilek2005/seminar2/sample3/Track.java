package me.nurtilek2005.seminar2.sample3;

public class Track implements Obstacle {

    private final int length;


    public Track(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}

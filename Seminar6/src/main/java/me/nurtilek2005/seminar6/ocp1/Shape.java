package me.nurtilek2005.seminar6.ocp1;

public class Shape {

    private ShapeType type;


    public Shape(ShapeType type) {
        this.type = type;
    }

    public ShapeType getType() {
        return type;
    }
}

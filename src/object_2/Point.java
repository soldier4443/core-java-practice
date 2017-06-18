package object_2;

import java.util.Locale;

/**
 * Created by soldi on 2017-06-16.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point translate(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    public Point scale(double scaleFactor) {
        return new Point(this.x * scaleFactor, this.y * scaleFactor);
    }

    public Point mutableTranslate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    public Point mutableScale(double scaleFactor) {
        this.x *= scaleFactor;
        this.y *= scaleFactor;
        return this;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "[%f, %f]", x, y);
    }
}



/**
 * Write a description of class Lab3_PointMovablePoint  here.
 *
 * @author (fathiya)
 * @version (12/2/2026)
 */
// ========= Point Class =========
class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getXY() {
        return new double[]{x, y};
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// ========= MovablePoint Class =========
class MovablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    public MovablePoint() {
        super();
        xSpeed = 0.0;
        ySpeed = 0.0;
    }

    public MovablePoint(double xSpeed, double ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() { return xSpeed; }
    public void setXSpeed(double xSpeed) { this.xSpeed = xSpeed; }

    public double getYSpeed() { return ySpeed; }
    public void setYSpeed(double ySpeed) { this.ySpeed = ySpeed; }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double[] getSpeed() {
        return new double[]{xSpeed, ySpeed};
    }

    public MovablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }

    public String toString() {
        return super.toString() + " speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}

// ========= Main Class =========
public class Lab3_PointMovablePoint {
    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point(3.0, 4.0);

        System.out.println("Default point: " + p1);
        System.out.println("Point at (3,4): " + p2);

        MovablePoint mp = new MovablePoint(0.0, 0.0, 2.0, 3.0);
        System.out.println("Before move: " + mp);

        mp.move();
        System.out.println("After move: " + mp);

        // Polymorphism
        Point p3 = new MovablePoint(1.0, 1.0, 0.5, 0.5);
        System.out.println("p3 class: " + p3.getClass().getSimpleName());

        if (p3 instanceof MovablePoint) {
            MovablePoint temp = (MovablePoint) p3;
            temp.move();
            System.out.println("After downcast move: " + temp);
        }
    }
}



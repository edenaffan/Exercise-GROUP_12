
/**
 * Write a description of class Lab4_ShapeHierarchy here.
 *
 * @author (mwatima)
 * @version (12/2/2026)
 */
// ========= Shape Class =========
class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        color = "red";
        filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }

    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}

// ========= Circle Class =========
class Circle extends Shape {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Circle[" + super.toString() + ", radius=" + radius + "]";
    }
}

// ========= Rectangle Class =========
class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public String toString() {
        return "Rectangle[" + super.toString() +
                ", width=" + width +
                ", length=" + length + "]";
    }
}

// ========= Square Class =========
class Square extends Rectangle {

    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    // Maintain square rule
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}

// ========= Main Class =========
public class Lab4_ShapeHierarchy {
    public static void main(String[] args) {

        Shape s1 = new Shape("yellow", false);
        Circle c1 = new Circle(5.0, "blue", true);
        Rectangle r1 = new Rectangle(4.0, 6.0, "green", true);
        Square sq1 = new Square(5.0, "orange", false);

        System.out.println(s1);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());

        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());

        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());

        // Square invariant test
        Square sq2 = new Square(3.0);
        sq2.setWidth(7.0);
        System.out.println("Width: " + sq2.getWidth() + ", Length: " + sq2.getLength());

        // Polymorphism
        Shape[] shapes = {
                new Circle(3.0, "red", true),
                new Rectangle(4.0, 5.0, "blue", false),
                new Square(6.0, "green", true)
        };

        double totalArea = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                totalArea += ((Square) shape).getArea();
            } else if (shape instanceof Rectangle) {
                totalArea += ((Rectangle) shape).getArea();
            } else if (shape instanceof Circle) {
                totalArea += ((Circle) shape).getArea();
            }
        }

        System.out.println("Total area: " + totalArea);
    }
}

/*
ANSWERS:

1. To keep width and length equal.
2. The square could become a rectangle.
3. Because Square is also a Rectangle.
4. Pros: Reuse code. Cons: Breaks Liskov Substitution Principle because a square behaves differently.
*/

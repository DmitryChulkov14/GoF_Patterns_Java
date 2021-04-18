package structural;

/**
 * Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently.
 * This type of design pattern comes under structural pattern as this pattern decouples implementation class
 * and abstract class by providing a bridge structure between them.
 * <br />
 * <br />
 * Мост используется, когда нам нужно отделить абстракцию от ее реализации, чтобы они могли различаться независимо.
 * Этот тип шаблона проектирования относится к структурному шаблону, поскольку этот шаблон разделяет класс реализации
 * и абстрактный класс, обеспечивая между ними структуру моста.
 */
public class Bridge {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

abstract class Shape {
    final DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    abstract void draw();
}

class Circle extends Shape {

    private final int x;
    private final int y;
    private final int radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}

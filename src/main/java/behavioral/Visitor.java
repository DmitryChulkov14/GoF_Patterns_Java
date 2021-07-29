package behavioral;

/**
 * Visitor represent an operation to be performed on the element.
 * Visitor allows to define a new operation without changing the classes of the elements on which it operates.
 * <br/>
 * <br/>
 * Посетитель представляет операцию для выполнения на элементе.
 * Посетитель позволяет определить новую операцию без изменения классов элементов которыми он управляет.
 */
public class Visitor {
    public static void main(String[] args) {
        Circle circle = new Circle(1, 2, 4);
        Rectangle rectangle = new Rectangle(10, 12, 5, 6);

        FileSaver jsonFileSaver = new JSONFileSaver();
        circle.saveToFile(jsonFileSaver);
        rectangle.saveToFile(jsonFileSaver);

        System.out.println();

        FileSaver xmlFileSaver = new XMLFileSaver();
        circle.saveToFile(xmlFileSaver);
        rectangle.saveToFile(xmlFileSaver);
    }
}

interface FileSaver {
    void saveToFile(Circle circle);

    void saveToFile(Rectangle rectangle);
}

class JSONFileSaver implements FileSaver {

    @Override
    public void saveToFile(Circle circle) {
        System.out.println("{\"type\":\"circle\", " +
                "\"x\":" + circle.getxPos() +
                ", \"y\":" + circle.getyPos() +
                ", \"r\":" + circle.getRadius() +
                "}");
    }

    @Override
    public void saveToFile(Rectangle rectangle) {
        System.out.println("{\"type\":\"rectangle\", " +
                "\"x\":" + rectangle.getxPos() +
                ", \"y\":" + rectangle.getyPos() +
                ", \"w\":" + rectangle.getWidth() +
                ", \"h\":" + rectangle.getHeight() +
                "}");
    }
}

class XMLFileSaver implements FileSaver {

    @Override
    public void saveToFile(Circle circle) {
        System.out.println("<circle " +
                "x=\"" + circle.getxPos() + "\" " +
                "y=\"" + circle.getyPos() + "\" " +
                "r=\"" + circle.getRadius() + "\"/>");
    }

    @Override
    public void saveToFile(Rectangle rectangle) {
        System.out.println("<rectangle " +
                "x=\"" + rectangle.getxPos() + "\" " +
                "y=\"" + rectangle.getyPos() + "\" " +
                "w=\"" + rectangle.getWidth() + "\" " +
                "h=\"" + rectangle.getHeight() + "\"/>");
    }
}

abstract class Shape {

    private int xPos;
    private int yPos;

    public Shape(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    abstract void saveToFile(FileSaver fileSaver);
}

class Circle extends Shape {

    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    void saveToFile(FileSaver fileSaver) {
        fileSaver.saveToFile(this);
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    void saveToFile(FileSaver fileSaver) {
        fileSaver.saveToFile(this);
    }
}

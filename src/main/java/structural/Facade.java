package structural;

/**
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 * This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
 * <br/>
 * <br/>
 * Шаблон фасада скрывает сложности системы и предоставляет клиенту интерфейс, с помощью которого он может получить доступ к системе.
 * Этот шаблон включает в себя один класс, который предоставляет упрощенные методы, необходимые клиенту, и делегирует вызовы методам существующих системных классов.
 */
public class Facade {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

        System.out.println();

        shapeMaker.drawAllShapes();
    }
}

interface FacadeShape {
    void draw();
}

class Rectangle implements FacadeShape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

class Square implements FacadeShape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

class ShapeMaker {
    private final Rectangle rectangle;
    private final Square square;

    public ShapeMaker() {
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawAllShapes() {
        rectangle.draw();
        square.draw();
    }
}

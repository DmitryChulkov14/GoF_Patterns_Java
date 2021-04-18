package structural;

/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
 * <br/>
 * <br/>
 * Шаблон декоратора позволяет пользователю добавлять новые функции к существующему объекту без изменения его структуры.
 * Этот шаблон создает класс-декоратор, который обертывает исходный класс и обеспечивает дополнительную функциональность, сохраняя неизменной сигнатуру методов класса.
 * */
public class Decorator {
    public static void main(String[] args) {

        Text text = new Text("Hello decorator!");
        System.out.println("Normal text:");
        text.print();

        System.out.println();
        System.out.println();

        TextDecorator boldText = new BoldTextDecorator(text);
        System.out.println("Bold text:");
        boldText.print();

        System.out.println();
        System.out.println();

        TextDecorator boldItalicsText = new BoldTextDecorator(new ItalicsTextDecorator(text));
        System.out.println("Bold italics text:");
        boldItalicsText.print();

    }
}

interface IPrintable {
    void print();
}

class Text implements IPrintable {

    private final String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.print(text);
    }
}

class TextDecorator implements IPrintable {
    IPrintable decoratedIprintable;

    public TextDecorator(IPrintable decoratedIprintable) {
        this.decoratedIprintable = decoratedIprintable;
    }

    @Override
    public void print() {
        decoratedIprintable.print();
    }
}

class BoldTextDecorator extends TextDecorator {

    public BoldTextDecorator(IPrintable decoratedIprintable) {
        super(decoratedIprintable);
    }

    @Override
    public void print() {
        System.out.print("<b>");
        super.decoratedIprintable.print();
        System.out.print("</b>");
    }
}

class ItalicsTextDecorator extends TextDecorator {

    public ItalicsTextDecorator(IPrintable decoratedIprintable) {
        super(decoratedIprintable);
    }

    @Override
    public void print() {
        System.out.print("<i>");
        super.decoratedIprintable.print();
        System.out.print("</i>");
    }
}

package creational;

/**
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.
 * This pattern involves implementing a prototype interface which tells to create a clone of the current object.
 * This pattern is used when creation of object directly is costly.
 * For example, an object is to be created after a costly database operation.
 * We can cache the object, returns its clone on next request and update the database as and when needed thus reducing database calls.
 * <br/>
 * <br/>
 * Шаблон прототипа относится к созданию повторяющегося объекта с учетом производительности.
 * Этот шаблон включает реализацию интерфейса прототипа, который сообщает о создании клона текущего объекта.
 * Этот шаблон используется, когда создание объекта напрямую требует больших затрат.
 * Например, объект должен быть создан после дорогостоящей операции с базой данных.
 * Мы можем кэшировать объект, возвращать его клон при следующем запросе и обновлять базу данных по мере необходимости, тем самым уменьшая количество обращений к базе данных.
 * */
public class Prototype {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setId(1);

        System.out.println(circle.getId());
        System.out.println(circle.getType());
        circle.draw();
        System.out.println(circle);

        Circle circleClone = (Circle) circle.clone();

        System.out.println(circleClone.getId());
        System.out.println(circleClone.getType());
        circleClone.draw();
        System.out.println(circleClone);
    }

}

abstract class Shape implements Cloneable {
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    void draw(){
        System.out.println(type + " are drawn!");
    };

    @Override
    protected Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace();
        }
        return clone;
    }
}

class Circle extends Shape {

    public Circle(){
        setType("Circle");
    }
}

package creational;

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

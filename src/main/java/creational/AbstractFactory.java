package creational;

public class AbstractFactory {
    public static void main(String[] args) {
        IAbstractFactory factory = new AncientFactory();
        System.out.println("Ancient factory was created!");
        factory.createChair().getChairType();
        factory.createSofa().getSofaType();

        factory = new ModernFactory();
        System.out.println("Modern factory was created!");
        factory.createChair().getChairType();
        factory.createSofa().getSofaType();
    }

}

interface IAbstractFactory {

    Chair createChair();

    Sofa createSofa();
}

class AncientFactory implements IAbstractFactory {

    @Override
    public Chair createChair() {
        return new AncientChair();
    }

    @Override
    public Sofa createSofa() {
        return new AncientSofa();
    }
}

class ModernFactory implements IAbstractFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

interface Chair {
    void getChairType();
}

class AncientChair implements Chair {

    @Override
    public void getChairType() {
        System.out.println("Ancient chair was created!");
    }
}

class ModernChair implements Chair {

    @Override
    public void getChairType() {
        System.out.println("Modern chair was created!");
    }
}

interface Sofa {
    void getSofaType();
}

class AncientSofa implements Sofa {

    @Override
    public void getSofaType() {
        System.out.println("Ancient sofa was created!");
    }
}

class ModernSofa implements Sofa {

    @Override
    public void getSofaType() {
        System.out.println("Modern sofa was created!");
    }
}

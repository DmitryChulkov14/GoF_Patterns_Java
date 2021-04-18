package creational;

/**
 * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
 * <br/>
 * <br/>
 * В шаблоне Factory мы создаем объект, не открывая клиенту логику создания, и ссылаемся на вновь созданный объект, используя общий интерфейс.
 * */
public class FactoryMethod {
    public static void main(String[] args) {
        TransportFactory transportFactory = new TransportFactory();
        Transport truck = transportFactory.createTransport(TransportType.TRUCK);
        Transport ship = transportFactory.createTransport(TransportType.SHIP);

        truck.deliver();
        ship.deliver();
    }
}

class TransportFactory {

    public Transport createTransport(TransportType transportType) {
        Transport transport = null;
        switch (transportType) {
            case TRUCK:
                transport = new Truck();
                break;
            case SHIP:
                transport = new Ship();
                break;
        }
        return transport;
    }
}

interface Transport {
    void deliver();
}

class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivering by truck!");
    }
}

class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("Delivering by ship!");
    }
}

enum TransportType {
    TRUCK, SHIP
}

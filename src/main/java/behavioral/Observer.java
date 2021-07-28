package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
 * its dependent objects are to be notified automatically.
 * <br/>
 * <br/>
 * Шаблон наблюдателя используется, когда между объектами существует связь «один ко многим»,
 * например, если один объект изменен, его зависимые объекты должны быть уведомлены автоматически.
 */
public class Observer {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexObserver(subject);

        int state = 10;
        System.out.println("First state: " + state);
        subject.setState(10);

        System.out.println("=====================");

        state = 15;
        System.out.println("First state: " + state);
        subject.setState(15);
    }
}

class Subject {
    private final List<ObserverImpl> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(ObserverImpl observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        observers.forEach(ObserverImpl::update);
    }
}

abstract class ObserverImpl {
    protected Subject subject;

    public abstract void update();
}

class BinaryObserver extends ObserverImpl {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}

class HexObserver extends ObserverImpl {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

package behavioral;

import java.util.Date;

/**
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes.
 * This pattern provides a mediator class which normally handles all the communications between different classes
 * and supports easy maintenance of the code by loose coupling.
 * <br/>
 * <br/>
 * Шаблон посредника используется для уменьшения сложности связи между несколькими объектами или классами.
 * Этот шаблон предоставляет класс-посредник, который обычно обрабатывает все коммуникации между различными классами
 * и поддерживает простое обслуживание кода за счет слабой связи.
 */
public class Mediator {
    public static void main(String[] args) {
        User vasya = new User("Vasya");
        User kolya = new User("Kolya");

        vasya.sendMessage("Hi! Kolya!");
        kolya.sendMessage("Hello! Vasya!");
    }
}

class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date() + " [" + user.getName() + "] : " + message);
    }
}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}

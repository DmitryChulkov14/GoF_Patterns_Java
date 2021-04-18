package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern is used where we need to treat a group of objects in similar way as a single object.
 * Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy.
 * This pattern creates a class that contains group of its own objects.
 * This class provides ways to modify its group of same objects.
 * <br/>
 * <br/>
 * Шаблон Composite используется там, где нам нужно одинаково рассматривать группу объектов как единый объект.
 * Шаблон Composite объединяет объекты в виде древовидной структуры для представления части, а также всей иерархии.
 * Этот шаблон создает класс, содержащий группу собственных объектов.
 * Этот класс предоставляет способы изменения своей группы одинаковых объектов.
 */
public class Composite {
    public static void main(String[] args) {
        Employee CEO = new Employee("Vasya", "CEO", 10000);
        Employee headMarketing = new Employee("Petya", "Head Marketing", 7000);
        Employee clerk1 = new Employee("Sergey", "Marketing", 2000);
        Employee clerk2 = new Employee("Gena", "Marketing", 2000);

        CEO.add(headMarketing);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        // print all employees of the organization
        System.out.println(CEO);
        CEO.getSubordinates().forEach(System.out::println);
        headMarketing.getSubordinates().forEach(System.out::println);
    }
}

class Employee {
    private final String name;
    private final String dept;
    private final int salary;
    private final List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee employee) {
        subordinates.add(employee);
    }

    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee: [ " +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                " ]";
    }
}

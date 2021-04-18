package creational;

/**
 * Builder pattern builds a complex object using simple objects and using a step by step approach.
 * A Builder class builds the final object step by step. This builder is independent of other objects.
 * <br/>
 * <br/>
 * Шаблон Builder создает сложный объект, используя простые объекты и используя пошаговый подход.
 * Класс Builder шаг за шагом строит окончательный объект. Этот строитель не зависит от других объектов.
 * */
public class Builder {
    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .withName("Vasya")
                .withSecondName("Pupkin")
                .withAge(25)
                .withHeight(180)
                .withWeight(80)
                .build();

        System.out.println(person1.toString());
    }
}

class Person {
    private String name;
    private String secondName;
    private int age;
    private int height;
    private int weight;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public static class Builder {
        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder withName(String name) {
            person.name = name;
            return this;
        }

        public Builder withSecondName(String secondName) {
            person.secondName = secondName;
            return this;
        }

        public Builder withAge(int age) {
            person.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            person.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            person.weight = weight;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}

package behavioral;

/**
 * Pattern Iterator is used to get a way to access the elements of a collection object
 * in sequential manner without any need to know its underlying representation.
 * <br/>
 * <br/>
 * Шаблон Итератор используется для получения доступа к элементам объекта коллекции
 * последовательным образом без необходимости знать его базовое представление.
 */
public class Iterator {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (IteratorInterface iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}

interface IteratorInterface {
    boolean hasNext();

    Object next();
}

interface Container {
    IteratorInterface getIterator();
}

class NameRepository implements Container {

    private final String[] names = {"Vasya", "Petya", "Lilya", "Olya"};

    @Override
    public IteratorInterface getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements IteratorInterface {

        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

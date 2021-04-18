package creational;

/**
 * Singleton pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 * <br/>
 * <br/>
 * Шаблон Singleton включает в себя один класс, который отвечает за создание объекта, обеспечивая создание только одного объекта.
 * Этот класс предоставляет способ доступа к своему единственному объекту, к которому можно получить доступ напрямую, без необходимости создавать экземпляр объекта класса.
 * */
public class Singleton {
    public static void main(String[] args) {
        SingletonCommon singletonCommon = SingletonCommon.getInstance();
        System.out.println(singletonCommon);
        SingletonCommon singletonCommon2 = SingletonCommon.getInstance();
        System.out.println(singletonCommon2);
        System.out.println();

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE.getInstance();
        System.out.println(singletonEnum.getInfo());
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE.getInstance();
        System.out.println(singletonEnum2.getInfo());

        singletonEnum2.setInfo("New class info");
        System.out.println(singletonEnum.getInfo());
        System.out.println(singletonEnum2.getInfo());
        System.out.println();

        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();
        System.out.println(doubleCheckedLockingSingleton);
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println(doubleCheckedLockingSingleton2);
        System.out.println();

        EarlyInitializationSingleton earlyInitializationSingleton = EarlyInitializationSingleton.getInstance();
        System.out.println(earlyInitializationSingleton);
        EarlyInitializationSingleton earlyInitializationSingleton2 = EarlyInitializationSingleton.getInstance();
        System.out.println(earlyInitializationSingleton2);
        System.out.println();

        InitOnDemandSingleton initOnDemandSingleton = InitOnDemandSingleton.getInstance();
        System.out.println(initOnDemandSingleton);
        InitOnDemandSingleton initOnDemandSingleton2 = InitOnDemandSingleton.getInstance();
        System.out.println(initOnDemandSingleton2);

    }

}

class SingletonCommon {

    private static SingletonCommon INSTANCE;

    private SingletonCommon(){}

    public static SingletonCommon getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonCommon();
        }
        return INSTANCE;
    }
}

// Thread-safety guaranteed approach by the enum implementation itself
enum SingletonEnum {
    INSTANCE("Initial class info");

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    SingletonEnum(String info) {
        this.info = info;
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}

// Thread-safety approach using double-checked locking and volatile variable
class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton INSTANCE;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return INSTANCE;
    }
}

// Thread-safety approach, but create an object on start of an application
class EarlyInitializationSingleton {
    private static final EarlyInitializationSingleton INSTANCE = new EarlyInitializationSingleton();

    private EarlyInitializationSingleton(){}

    public static EarlyInitializationSingleton getInstance() {
        return INSTANCE;
    }
}

// Thread-safety approach, using nested static class. Instance will be created on the first call getInstance()
class InitOnDemandSingleton {
    private InitOnDemandSingleton(){}

    private static class InstanceHolder {
        private static final InitOnDemandSingleton INSTANCE = new InitOnDemandSingleton();
    }

    public static InitOnDemandSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}

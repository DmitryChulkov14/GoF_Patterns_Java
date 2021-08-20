package behavioral;

/**
 * Strategy enables selecting an algorithm at runtime. Instead of implementing a single algorithm directly,
 * code receives run-time instructions.
 * <br/>
 * <br/>
 * Стратегия позволяет выбирать алгоритм во время выполнения. Вместо реализации единого алгоритма напрямую,
 * код получает инструкции во время выполнения.
 */
public class Strategy {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}

interface StrategyInterface {
    int doOperation(int num1, int num2);
}

class OperationAdd implements StrategyInterface {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements StrategyInterface {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class Context {
    private final StrategyInterface strategy;

    public Context(StrategyInterface strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

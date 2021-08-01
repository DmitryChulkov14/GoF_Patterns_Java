package behavioral;

/**
 * Interpreter pattern provides a way to evaluate language grammar or expression.
 * <br/>
 * <br/>
 * Шаблон интерпретатора позволяет оценить грамматику или выражение языка.
 */
public class Interpreter {

    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Vasya");
        Expression john = new TerminalExpression("Petya");
        return new OrExpression(robert, john);
    }

    public static Expression getMarriedWomanExpression() {
        Expression maria = new TerminalExpression("Maria");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(maria, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("Is Vasya male? " + isMale.interpret("Vasya"));
        System.out.println("Is Maria a married woman? " + isMarriedWoman.interpret("Married Maria"));
    }
}

interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {

    private final String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements Expression {

    private final Expression expression1;
    private final Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}

class AndExpression implements Expression {

    private final Expression expression1;
    private final Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}

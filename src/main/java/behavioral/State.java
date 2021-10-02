package behavioral;

/**
 * In State pattern a class behavior changes based on its state.
 * <br/>
 * <br/>
 * В шаблоне состояния поведение класса изменяется в зависимости от его состояния.
 */
public class State {
    public static void main(String[] args) {
        StateContext context = new StateContext();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}

interface StateInterface {
    void doAction(StateContext context);
}

class StartState implements StateInterface {

    @Override
    public void doAction(StateContext context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}

class StopState implements StateInterface {

    @Override
    public void doAction(StateContext context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}

class StateContext {
    private StateInterface state;

    public StateContext() {
        state = null;
    }

    public void setState(StateInterface state) {
        this.state = state;
    }

    public StateInterface getState() {
        return state;
    }
}

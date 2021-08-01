package behavioral;

/**
 * Template method defines algorithm step by step. The steps could be additionally defined/redefined in derived classes.
 * <br/>
 * <br/>
 * Шаблонный метод определяет алгоритм шаг за шагом. Шаги могут быть дополнительно определены/переопределены в производных классах.
 */
public class Template {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();

        System.out.println();

        game = new Basketball();
        game.play();
    }
}

abstract class Game {
    abstract void init();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        init();
        startPlay();
        endPlay();
    }
}

class Football extends Game {

    @Override
    void init() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

class Basketball extends Game {

    @Override
    void init() {
        System.out.println("Basketball Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Basketball Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Basketball Game Finished!");
    }
}

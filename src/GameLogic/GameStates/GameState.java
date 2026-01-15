package GameLogic.GameStates;
import GameLogic.GameManager;

public abstract class GameState {

    protected GameManager gameManager;
    public GameState(GameManager gm) {
        this.gameManager = gm;
    }

    public abstract void render();
 
    public abstract void update();

    public abstract void processInput();

}

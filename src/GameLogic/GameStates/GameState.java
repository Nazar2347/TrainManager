package GameLogic.GameStates;

public abstract class GameState {

    public GameState() {
        
    }

    public abstract void render();
 
    public abstract void update();

    public abstract void processInput();

}

package GameLogic.GameStates;

/**
 * Main gameplay state (renamed to GS_Game).
 */
public class GS_Game extends GameState {

    public GS_Game() {
        super();
    }

    @Override
    public void render() {
        System.out.println("GS_Game: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Game: update");
    }

    @Override
    public void processInput() {
        System.out.println("GS_Game: processInput");
    }

}

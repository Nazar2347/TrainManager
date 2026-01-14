package GameLogic.GameStates;

/**
 * Lose state (renamed to GS_Lose).
 */
public class GS_Lose extends GameState {

    public GS_Lose() {
        super();
    }

    @Override
    public void render() {
        System.out.println("GS_Lose: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Lose: update");
    }

    @Override
    public void processInput() {
        System.out.println("GS_Lose: processInput");
    }

}

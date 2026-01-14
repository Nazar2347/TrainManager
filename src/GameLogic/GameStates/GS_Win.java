package GameLogic.GameStates;

/**
 * Win state (renamed to GS_Win).
 */
public class GS_Win extends GameState {

    public GS_Win() {
        super();
    }

    @Override
    public void render() {
        System.out.println("GS_Win: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Win: update");
    }

    @Override
    public void processInput() {
        System.out.println("GS_Win: processInput");
    }

}

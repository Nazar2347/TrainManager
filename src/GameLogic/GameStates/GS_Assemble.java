package GameLogic.GameStates;

/**
 * Assemble state (renamed to GS_Assemble).
 */
public class GS_Assemble extends GameState {

    public GS_Assemble() {
        super();
    }

    @Override
    public void render() {
        System.out.println("GS_Assemble: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Assemble: update");
    }

    @Override
    public void processInput() {
        System.out.println("GS_Assemble: processInput");
    }

}

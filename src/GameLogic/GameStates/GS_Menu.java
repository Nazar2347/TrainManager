package GameLogic.GameStates;

/**
 * Menu state (renamed to GS_Menu).
 */
public class GS_Menu extends GameState {

    public GS_Menu() {
        super();
    }

    @Override
    public void render() {
        System.out.println("GS_Menu: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Menu: update");
    }

    @Override
    public void processInput() {
        System.out.println("GS_Menu: processInput");
    }

}

package GameLogic.GameStates;

import GameLogic.Player;
import GameObjects.Locomotive;
import GameObjects.Wagon;

/**
 * Shop state (renamed to GS_Shop).
 */
public class GS_Shop extends GameState {
    private Player player;
    private Locomotive[] availableLocomotives;
    private Wagon[] availableWagons;

    public GS_Shop() {
        super();
    }

    @Override
    public void render() {
        System.out.println("GS_Shop: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Shop: update");
    }

    @Override
    public void processInput() {
        System.out.println("GS_Shop: processInput");
    }

    private void buyFuel() {
        // Implementation for buying fuel and refueling locomotives
    }

    public void buyLocomotive() {
        // Implementation for purchasing a locomotive
    }

    public void buyWagon() {
        // Implementation for purchasing a wagon
    }

}

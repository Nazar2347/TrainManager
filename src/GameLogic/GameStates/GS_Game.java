package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.GameManager;
import GameLogic.Player;

/**
 * Main gameplay state (renamed to GS_Game).
 */
public class GS_Game extends GameState {

    public GS_Game(GameManager gm) {
        super(gm);
    }

    @Override
    public void render() {
        System.out.println("GS_Game: render");
    }

    @Override
    public void update() {
        System.out.println("GS_Game: update");
        //TODO:: Implement Win Fail logic
        //===temporary====
        gameManager.SetState(new GS_Lose(gameManager));
    }

    @Override
    public void processInput() {
        System.out.println("GS_Game: processInput");
        
    }

}

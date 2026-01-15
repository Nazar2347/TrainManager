package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.GameManager;

/**
 * Lose state (renamed to GS_Lose).
 */
public class GS_Lose extends GameState {

    public GS_Lose(GameManager gm) {
        super(gm);
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter [T] - to try again: ");
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'T' || Command == 't') {
            gameManager.SetState(new GS_Menu(gameManager));
        }
       
    }

}

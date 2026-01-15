package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.GameManager;

/**
 * Assemble state (renamed to GS_Assemble).
 */
public class GS_Assemble extends GameState {

    public GS_Assemble(GameManager gm) {
        super(gm);
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter [Y] to assemble | [S] to shop: ");
        char Command = scanner.nextLine().charAt(0);

        if (Command == 'Y' || Command == 'y') {
            gameManager.SetState(new GS_Game(gameManager));
        }
        else if(Command == 'N' || Command == 'n')
        {
            gameManager.SetState(new GS_Shop(gameManager));
        }
        //scanner.nextLine();

    }

}

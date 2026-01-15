package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.GameManager;

/**
 * Menu state (renamed to GS_Menu).
 */
public class GS_Menu extends GameState {

    public GS_Menu(GameManager gm) {
        super(gm);
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
          Scanner scanner = new Scanner(System.in);
        System.out.print("Enter [P] to play | [E] to exit: ");
        char Command = scanner.nextLine().charAt(0);

        if (Command == 'P' || Command == 'p') {
            gameManager.SetState(new GS_Assemble(gameManager));
        }
        else if(Command == 'E' || Command == 'e')
        {
           gameManager.setRunning(false);
        }
    }

}

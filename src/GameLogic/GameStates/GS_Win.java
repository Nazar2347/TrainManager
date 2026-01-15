package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.GameManager;

/**
 * Win state (renamed to GS_Win).
 */
public class GS_Win extends GameState {

    public GS_Win(GameManager gm) {
        super(gm);
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press [F] - to pay respect: ");
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'F' || Command == 'f') {
           gameManager.setRunning(false);;
        }
    }

}

package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.GameManager;
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

    public GS_Shop(GameManager gm) {
        super(gm);
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
          Scanner scanner = new Scanner(System.in);
        System.out.print("Enter [C] to continue | [E] to go back to assamble: ");
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'C' || Command == 'c') {
            gameManager.SetState(new GS_Game(gameManager));
        }
        else if(Command == 'E' || Command == 'e')
        {
           gameManager.SetState(new GS_Assemble(gameManager));
        }
    }

    private void buyFuel() {
        //TODO: Implementation for buying fuel and refueling locomotives
    }

    public void buyLocomotive() {
        //TODO: Implementation for purchasing a locomotive
    }

    public void buyWagon() {
        //TODO: Implementation for purchasing a wagon
    }

}

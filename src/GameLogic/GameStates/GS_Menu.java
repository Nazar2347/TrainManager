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
        System.out.println(
            
                        " /$$$$$$$$                 /$$                 /$$      /$$                                                            \r" + 
                        "|__  $$__/                |__/                | $$$    /$$$                                                            \r" + 
                        "   | $$  /$$$$$$  /$$$$$$  /$$ /$$$$$$$       | $$$$  /$$$$  /$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$ \r" + 
                        "   | $$ /$$__  $$|____  $$| $$| $$__  $$      | $$ $$/$$ $$ |____  $$| $$__  $$ |____  $$ /$$__  $$ /$$__  $$ /$$__  $$\r" + 
                        "   | $$| $$  \\__/ /$$$$$$$| $$| $$  \\ $$      | $$  $$$| $$  /$$$$$$$| $$  \\ $$  /$$$$$$$| $$  \\ $$| $$$$$$$$| $$  \\__/\r" + 
                        "   | $$| $$      /$$__  $$| $$| $$  | $$      | $$\\  $ | $$ /$$__  $$| $$  | $$ /$$__  $$| $$  | $$| $$_____/| $$      \r" + 
                        "   | $$| $$     |  $$$$$$$| $$| $$  | $$      | $$ \\/  | $$|  $$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$$|  $$$$$$$| $$      \r" + 
                        "   |__/|__/      \\_______/|__/|__/  |__/      |__/     |__/ \\_______/|__/  |__/ \\_______/ \\____  $$ \\_______/|__/      \r" + 
                        "                                                                                          /$$  \\ $$                    \r" + 
                        "                                                                                         |  $$$$$$/                    \r" + 
                        "                                                                                          \\______/                     "    
                    );
    }

    @Override
    public void update() {
        System.out.println("GS_Menu: update");
       
    }

    @Override
    public void processInput() {
        System.out.println("GS_Menu: processInput"); //DEBUG
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

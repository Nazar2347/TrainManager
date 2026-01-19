// Simple Hello World program

import GameLogic.GameManager;
import GameLogic.Player;

public class Main {
    private static Player player=new Player("Player1", 1000);
    private static GameManager gameManager=new GameManager(player);
    public static void main(String[] args) {
        System.out.println("{Train Manager}");
        gameManager.LoadPlayerData("profiles/TestProfile1/Player1.txt");
        while(gameManager.isRunning()) {
            gameManager.ReceiveInput();
            gameManager.Render();
            gameManager.Update();
        }
    }
}

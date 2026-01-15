// Simple Hello World program

import GameLogic.GameManager;

public class Main {
    private static GameManager gameManager=new GameManager();
    public static void main(String[] args) {
        System.out.println("{Train Manager}");
        while(gameManager.isRunning()) {
            gameManager.ReceiveInput();
            gameManager.Render();
            gameManager.Update();
        }
    }
}

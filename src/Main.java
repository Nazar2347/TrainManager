// Simple Hello World program

import GameLogic.GameManager;

public class Main {
    private static GameManager gameManager=new GameManager();
    public static void main(String[] args) {
        // Print "Hello World" to standard output
        System.out.println("Hello World");
        while(gameManager.isRunning()) {
            gameManager.ReceiveInput();
            gameManager.Update();
            gameManager.Render();
        }
    }
}

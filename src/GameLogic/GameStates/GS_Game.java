package GameLogic.GameStates;
import Render.TrainRender;
import GameLogic.Player;

import java.util.Scanner;

import GameLogic.GameManager;
import GameObjects.Locomotive;


/**
 * Main gameplay state (renamed to GS_Game).
 */
public class GS_Game extends GameState {

    public boolean bPause;
    private Player player;
    public GS_Game(GameManager gm) {
        super(gm);
        this.player = gameManager.getPlayer();
        this.bPause= false;
    }
    
    @Override
    public void render() 
    {
        if (bPause ==true)
        {
            return;
        }
        TrainRender trainRender=new TrainRender();
        trainRender.RenderTrain();
    }

    @Override
    public void update() {
        //System.out.println("GS_Game: update");
        //TODO:: Implement Win Fail logic
        
        if (player.GetMoneyBalance() <0)
        {
            gameManager.SetState(new GS_Lose(gameManager));
        }

        if (gameManager.getPlayer().getCurrentLocomotive() == null)
        {
             System.out.println("You cannot play without locomotive chosed");
             gameManager.SetState(new GS_Assemble(gameManager));
             return;
        }
        Locomotive playerLoco = player.getCurrentLocomotive();
        
        if (playerLoco.Input_Drive()==false)
        {
            gameManager.SetState(new GS_Shop(gameManager));
            return;
        }
        int distanceLeft = gameManager.GetTask().GetDistanceLeft();
        System.out.println("Kilometers left: "+ distanceLeft);
        if (gameManager.GetTask().tryCompleteTask())
        {
            gameManager.SetState(new GS_Win(gameManager));
        }
        else
        {
            if (distanceLeft == 0)
            {
                bPause =true;
            }
        }
    }

    @Override
    public void processInput() {
        if (bPause)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[C] - To try from begining");
            char Command = scanner.nextLine().charAt(0);
            if (Command == 'c'||Command =='C')
            {
                gameManager.SetState(new GS_Assemble(gameManager));
                bPause = false;
            }
        }
    }

}

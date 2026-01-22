package GameLogic.GameStates;

import java.util.Scanner;

import GameLogic.E_AssembleSubPage;
import GameLogic.GameManager;
import GameLogic.Player;
import GameObjects.Locomotive;
import GameObjects.Wagon;
import Render.TrainRender;
import Render.WagonRender;

/**
 * Assemble state (renamed to GS_Assemble).
 */
public class GS_Assemble extends GameState {

    public GS_Assemble(GameManager gm) {
        super(gm);
        currentSubPage = E_AssembleSubPage.MAIN;
    }
    private E_AssembleSubPage currentSubPage;

    @Override
    public void render() {
        System.out.println("GS_Assemble: render");
        switch (currentSubPage) {
            case MAIN:
                //TODO: Render main assemble page
                break;
            case CHOOSE_LOCOMOTIVE:
                Render_LocomotiveSelection();
                break;
            case CHOOSE_WAGON:
                Render_WagonSelection();
                break;
            default:
                break;
        }
    }

    @Override
    public void update() {
        System.out.println("GS_Assemble: update");
        switch (currentSubPage) 
        {
            case MAIN:
                
                break;
            case CHOOSE_LOCOMOTIVE:
                //TODO: Add/Remove locomotives
                break;
            case CHOOSE_WAGON:
                //TODO: Add/Remove wagons to/from locomotive
                break;
        }
    }

    private void ProcessInput_MainPage()
    {
        System.out.println("GS_Assemble: processInput");
        Scanner scanner = new Scanner(System.in);
        System.out.print("[T] to chose locomotive, [W] to choose wagon |\n ");
        System.out.print("Enter [P] to play | [S] to shop: ");
        char Command = scanner.nextLine().charAt(0);

       
        //Transition to Game 
        if (Command == 'P' || Command == 'p') {
            gameManager.SetState(new GS_Game(gameManager)); 
        }
        //Transition to Shop
        else if(Command == 'S' || Command == 's')
        {
            gameManager.SetState(new GS_Shop(gameManager));
        }
        else if(Command == 'T' || Command == 't')
        {
           currentSubPage = E_AssembleSubPage.CHOOSE_LOCOMOTIVE;
        }
        //Choose wagon
        else if (Command == 'W' || Command == 'w')
        {
           currentSubPage = E_AssembleSubPage.CHOOSE_WAGON;
        }
        else
        {
            System.out.println("Invalid command. Please try again.");
        }    
    }

    private void ProcessInput_ChooseLocomotivePage()
    {
        System.out.println("GS_Assemble: Choose Locomotive");
        System.out.println("[B] to go back to main page");
         Scanner scanner = new Scanner(System.in);
        char Command = scanner.nextLine().charAt(0);
         if (Command == 'B' || Command == 'b') {
            currentSubPage = E_AssembleSubPage.MAIN;
        }

    }
    private void ProcessInput_ChooseWagonPage()
    {
        System.out.println("GS_Assemble: Choose Wagon");
        System.out.println("[B] to go back to main page");
        Scanner scanner = new Scanner(System.in);
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'B' || Command == 'b') {
            currentSubPage = E_AssembleSubPage.MAIN;
        }


    }
    @Override
    public void processInput() {
       
        switch (currentSubPage) {
            case MAIN:
                ProcessInput_MainPage();
                break;
            case CHOOSE_LOCOMOTIVE:
                ProcessInput_ChooseLocomotivePage();
                break;
            case CHOOSE_WAGON:
                ProcessInput_ChooseWagonPage();
                break;
            default:
                System.out.println("Error:Unknown subpage.");
                break;
        }

    }
   

    public void Render_LocomotiveSelection()
    {
        Player player = gameManager.getPlayer();
        if (player == null) {
            System.out.println("No player assigned.");
            return;
        }
        if (player.GetOwnedLocomotives().isEmpty()) {
            System.out.println("You do not own any locomotives.");
            return;
        }

        System.out.println("Your current owned locomotives:");
        for (Locomotive loco : player.GetOwnedLocomotives()) {
            TrainRender render= new TrainRender();
            System.out.println(render.RenderLocomotive(loco.GetLocomotiveType()));
            System.out.println("[ " + loco.getName()+" ]\n");

        }
    }
    public void Render_WagonSelection()
    {
        Player player = gameManager.getPlayer();
        if (player == null) 
        {
            System.out.println("No player assigned.");
            return;
        }
        if (player.GetOwnedWagons().isEmpty()) 
        {
            System.out.println("You do not own any wagons.");
            return;
        }
        System.out.println("Your current owned wagons:");
        for (Wagon wagon : player.GetOwnedWagons()) {
            WagonRender render= new WagonRender();
            System.out.println(render.RenderWagon(wagon));
            System.out.println("[" + wagon.getName()+"]\n");
        }
    }

}

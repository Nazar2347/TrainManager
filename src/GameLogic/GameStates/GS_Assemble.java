package GameLogic.GameStates;

import java.util.Scanner;
import java.util.Vector;

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
        Player player = gameManager.getPlayer();
        Vector<Locomotive> locomotiveArray = new Vector<Locomotive>(player.GetOwnedLocomotives());

        Render_CurrentTrainSet();
        if (!locomotiveArray.isEmpty())
        {
            System.out.println("Pick Locomotive to your trainp set: [0-"+(locomotiveArray.size()-1)+"]");
        }
        else
        {
            System.out.println("You do not have any locomotives in your inventory!!");
        }
        System.out.println("[99] to go back to main page");
        Scanner scanner = new Scanner(System.in);
        int Command = scanner.nextInt();
        try 
        {
            if (Command == 99 ) 
            {
                currentSubPage = E_AssembleSubPage.MAIN;
                return;
            }

            Locomotive loco = locomotiveArray.get(Command);
            if (loco !=null)
            {
                //If there are locomotive in a set
                if (player.getCurrentLocomotive()!= null)
                {
                    Locomotive oldLoco = player.getCurrentLocomotive();
                    player.AddLocomotiveToInventory(oldLoco);
                    
                }
                player.SetCurrenntLocomotive(loco);
                player.RemoveLocomotiveFromInventory(loco);
                ProcessInput_ChooseLocomotivePage();;
                return;
            }
        }
        catch(Exception e)
        { 
            System.out.println("There is no wagon under index ["+Command+"] ");
            ProcessInput_ChooseLocomotivePage();
            return;
        }

    }
    private void ProcessInput_ChooseWagonPage()
    {
        Player player = gameManager.getPlayer();
        Vector<Wagon> wagonArray = new Vector<Wagon>(player.GetOwnedWagons());

        Render_CurrentTrainSet();
        if (!wagonArray.isEmpty())
        {
            System.out.println("Pick wagon to your train set: [0-"+(wagonArray.size()-1)+"]");
        }
        else
        {
            System.out.println("You do not have any wagons in your inventory!!");
        }
        System.out.println("[95] remove last wagon from train set");
        System.out.println("[99] to go back to main page");
        Scanner scanner = new Scanner(System.in);
        int Command = scanner.nextInt();
        try 
        {
            if (Command == 99 ) 
            {
                currentSubPage = E_AssembleSubPage.MAIN;
                return;
            }
            if (Command ==95)
            {
                int lastWagonIndex = player.getCurrentWagonSet().size()-1;
                Wagon lastWagon = player.getCurrentWagonSet().get(lastWagonIndex);
                player.AddWagonToInventory(lastWagon);
                player.RemoveWagonFromSet(lastWagonIndex);
                
            }

            Wagon wagon = wagonArray.get(Command);
            if (wagon !=null)
            {
                player.AddWagonsToWagonSet(wagon);
                player.RemoveWagonFromInventory(wagon);
                ProcessInput_ChooseWagonPage();
                return;
            }
        }
        catch(Exception e)
        { 
            System.out.println("There is no wagon under index ["+Command+"] ");
            ProcessInput_ChooseWagonPage();
            return;
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
    public void Render_CurrentTrainSet()
    {
         Player player = gameManager.getPlayer();
         String trainSetString = new String("Train: ");
        if (player == null) 
        {
            System.out.println("No player assigned.");
            return;
        }
        if (player.getCurrentLocomotive()== null)
        {
            trainSetString +="{x}.";
        }
        else
        {
            trainSetString +="{"+player.getCurrentLocomotive().getName()+"}.";
        }
        if (player.getCurrentWagonSet().isEmpty()) 
        {
            trainSetString +="No wagons";
        }
        for (Wagon wagon : player.getCurrentWagonSet()) {
            trainSetString+="["+wagon.getName()+"]";
        }
        trainSetString +="\n";
        System.out.println(trainSetString);
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

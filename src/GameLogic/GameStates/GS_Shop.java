package GameLogic.GameStates;


import java.util.Scanner;
import java.util.Vector;

import GameLogic.GameManager;
import GameLogic.Player;
import GameObjects.Locomotive;
import GameObjects.Wagon;
import Render.TrainRender;
import Render.WagonRender;
import GameLogic.Shop;

/**
 * Shop state (renamed to GS_Shop).
 */
public class GS_Shop extends GameState {
    private Shop shop;
    private E_ShopSubPage page;


    public GS_Shop(GameManager gm) {
        super(gm);
        shop = new Shop();  
        page = E_ShopSubPage.MAIN;      

    }

    @Override
    public void render() {
         switch (page) {
        case MAIN:
            Render_ShopMenu();
            break;
        case LOCOMOTIVE:
            Render_LocomotiveSelection();
            break;
        case WAGONS:
            Render_WagonSelection();
            break;
        case FUEL:
            Render_ShopFuel();
            break;

        default:
            break;
     }
    }

    @Override
    public void update() {
        System.out.println("GS_Shop: update");
    }

    @Override
    public void processInput() {
     switch (page) {
        case MAIN:
            ProcessInput_MainPage();
            break;
        case LOCOMOTIVE:
            ProcessInput_ChooseLocomotivePage();
            break;
        case WAGONS:
            ProcessInput_ChooseWagonPage();
            break;
        case FUEL:
            ProcessInput_ShopFuel();
            break;

        default:
            break;
     }
    }

    private void buyFuel(Player player)
    {
        if (player.getCurrentLocomotive()!= null)
        {
            Locomotive loco =player.getCurrentLocomotive();
            float locofuel = loco.GetCurrentFuelLevel();
            float maxfuel = loco.GetFuelCapacityLevel();
            int cost = (int)(maxfuel-locofuel)/10;
            int balance = player.GetMoneyBalance();
            balance -=cost;
            player.SetMoneyBalance(balance);
            loco.Refuel();
            System.out.println("Purchased!! Your balance after refueling: "+balance);
        }
        else
        {
            System.out.println("No locomotive in your current train set. Please select locomotive");
        }
    }

    public void buyLocomotive(Player currentPlayer, Locomotive purcasedLocomotive) {
        
        int playerBalance = currentPlayer.GetMoneyBalance();
        int locomotivePrice = 100; // TODO: purchase locomotive
        playerBalance-=locomotivePrice;
        currentPlayer.SetMoneyBalance(playerBalance);
        currentPlayer.AddLocomotiveToInventory(purcasedLocomotive);
        

        TrainRender render = new TrainRender();
        String locomotiveRender =render.RenderLocomotive(purcasedLocomotive.GetLocomotiveType());
        System.out.println(locomotiveRender);
        System.out.println("You purchased: "+ purcasedLocomotive.getName()+" !");
        System.out.println ("Balance $: "+playerBalance);
        //System.out.println("Locomotive:", )
    }

    public void buyWagon(Player currentPlayer, Wagon purchasedWagon) {
        //TODO: Implementation for purchasing a wagon
        int playerBalance = currentPlayer.GetMoneyBalance();
        int wagonPrice = 100; // TODO: purchase wagon
        playerBalance -= wagonPrice;
        currentPlayer.SetMoneyBalance(playerBalance);
        currentPlayer.AddWagonToInventory(purchasedWagon);

        WagonRender render = new WagonRender();
        String wagonRender = render.RenderWagon(purchasedWagon);
        System.out.println(wagonRender);
        System.out.println("You purchased: "+ purchasedWagon.getName()+" !");
        System.out.println ("Balance $: "+playerBalance);
        
    }

    public void ProcessInput_MainPage()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[L] - Locomotives, [W] - wagons, [F] - fuel");
        System.out.print("Enter [C] play | [E] to go back to assamble: ");
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'C' || Command == 'c') {
            gameManager.SetState(new GS_Game(gameManager));
        }
        else if(Command == 'E' || Command == 'e')
        {
           gameManager.SetState(new GS_Assemble(gameManager));
        }
        else if (Command =='L'|| Command=='l' )
        {
            page = E_ShopSubPage.LOCOMOTIVE;           
        }
        else if (Command =='W'|| Command =='w')
        {
            page = E_ShopSubPage.WAGONS;
        }
        else if (Command =='F'|| Command =='f')
        {
            page = E_ShopSubPage.FUEL;
        }
    }
    public void ProcessInput_ChooseLocomotivePage()
    {
        System.out.println("LocomotiveShop:");
        System.out.println("Type from [0 - "+shop.GetAvlaiableLocomotives().size()+
            "] to buy certain locomotive");
        System.out.println ("[99] Cancel, go back");
        Scanner scanner = new Scanner(System.in);
        int Command = scanner.nextInt();
        try 
        {
            if (Command == 99)
            {
                page = E_ShopSubPage.MAIN;
                return;
            }
            Locomotive loco = shop.GetAvlaiableLocomotives().get(Command);
            if (loco != null)
            {
                buyLocomotive(gameManager.getPlayer(),loco);
                ProcessInput_ChooseLocomotivePage();
                return;
            }

        }
        catch(Exception e)
        {
            System.out.println("There is no locomotive under index ["+Command+"] ");
            ProcessInput_ChooseLocomotivePage();
            return;
        }
        
    }
    public void ProcessInput_ShopFuel()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[Y] - to purchase, [N] - Cancel, return back");
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'Y'||Command =='y')
        {
           buyFuel(gameManager.getPlayer());
           
        }
        else if (Command =='N'|| Command =='n')
        {
            page = E_ShopSubPage.MAIN;
        }
        
        
    }
    
    public void ProcessInput_ChooseWagonPage()
    {
        System.out.println("LocomotiveShop:");
        System.out.println("Type from [0 - "+shop.GetAvaliableWagons().size()+
            "] to buy certain wagon");
        System.out.println ("[99] Cancel, go back");
        Scanner scanner = new Scanner(System.in);
        int Command = scanner.nextInt();
        if (Command == 99)
        {
            page = E_ShopSubPage.MAIN;
            return;
        }
        try 
        {
            Wagon wagon = shop.GetAvaliableWagons().get(Command);
            if (wagon != null)
            {
                buyWagon(gameManager.getPlayer(),wagon);
                ProcessInput_ChooseWagonPage();
                return;
            }
        }
        catch(Exception e)
        {
            System.out.println("There is no locomotive under index ["+Command+"] ");
            ProcessInput_ChooseLocomotivePage();
        }
    }
    public void Render_WagonSelection()
    {
        if (shop.GetAvaliableWagons()==null)
        {
            System.out.println("No wagons are avaliable for shopping");
            return;
        }
        WagonRender render = new WagonRender();
        Vector <Wagon> wagons = new Vector<Wagon>(shop.GetAvaliableWagons());
        for (Wagon i : wagons)
        {
            System.out.print(render.RenderWagon(i));
            System.out.println("["+wagons.indexOf(i)+"] "+i.getName()+" Price: "); //TODO: get Wagon price 
        }
    }
    public void Render_LocomotiveSelection()
    {
         if (shop.GetAvaliableWagons()==null)
        {
            System.out.println("No locomotives are avaliable for shopping");
            return;
        }
        TrainRender render = new TrainRender();
        Vector<Locomotive> loco = new Vector<Locomotive>(shop.GetAvlaiableLocomotives());
        for (Locomotive i : loco)
        {
            String renderLoco =  render.RenderLocomotive(i.GetLocomotiveType());
            System.out.print(renderLoco);
            
            System.out.println("["+loco.indexOf(i)+"]" +i.getName()+ "Price: ");
        }
    }
    public void Render_ShopMenu()
    {
        System.out.println("Welcome to Shop!");
        System.out.println("What would you like to buy?");

    }
    public void Render_ShopFuel()
    {
        if (gameManager.getPlayer().getCurrentLocomotive() != null)
        {
            float fuel = gameManager.getPlayer().getCurrentLocomotive().GetCurrentFuelLevel();
            float maxfuel = gameManager.getPlayer().getCurrentLocomotive().GetFuelCapacityLevel();
            int costForRefuel = (int)(maxfuel-fuel)/10;
            System.out.println("Your fuel level: "+fuel+" / "+maxfuel);
            System.out.println("Cost to refuel:"+ costForRefuel);
        }
        
    }
}

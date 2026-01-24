package GameLogic.GameStates;

import java.util.HashSet;
import java.util.Scanner;

import GameLogic.GameManager;
import GameLogic.Player;
import GameObjects.E_LocomotiveType;
import GameObjects.Locomotive;
import GameObjects.Wagon;
import Render.TrainRender;
import Render.WagonRender;
import GameLogic.Shop;

/**
 * Shop state (renamed to GS_Shop).
 */
public class GS_Shop extends GameState {
    private Player player;
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

    private void buyFuel() {
        //TODO: Implementation for buying fuel and refueling locomotives
    }

    public void buyLocomotive() {
        // Show list of all trains (price - money)
        TrainRender render = new TrainRender();
        
        render.RenderLocomotive(E_LocomotiveType.E_Type1);
        //System.out.println("Locomotive:", )
    }

    public void buyWagon() {
        //TODO: Implementation for purchasing a wagon
    }

    public void ProcessInput_MainPage()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to buy?");
        System.out.println("[L]- Locomotives, [W]- wagons");
        System.out.print("Enter [C] to continue | [E] to go back to assamble: ");
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
    }
    public void ProcessInput_ChooseLocomotivePage()
    {
        System.out.println("LocomotiveShop:");
        System.out.println ("[C] Cancel, go back");
        Scanner scanner = new Scanner(System.in);
        char Command = scanner.nextLine().charAt(0);
         if (Command =='C'||Command =='c')
        {
            page = E_ShopSubPage.MAIN;
        }
    }
    public void ProcessInput_ShopFuel()
    {
        System.out.println("[B - to purchase], [N]-Cancel, return back");
        Scanner scanner = new Scanner(System.in);
        char Command = scanner.nextLine().charAt(0);
        if (Command == 'B'||Command =='b')
        {
           shop.BuyFuel();
        }
        else if (Command =='C'|| Command =='c')
        {
            page = E_ShopSubPage.MAIN;
        }
        int Summ = scanner.nextInt();
        
    }
    public void ProcessInput_ChooseWagonPage()
    {
        System.out.println("WagonShop:");
        System.out.println("[C]-Cancel,return back");
        Scanner scanner = new Scanner(System.in);
        char Command = scanner.nextLine().charAt(0);
        if (Command =='C'||Command =='c')
        {
            page = E_ShopSubPage.MAIN;
        }
    }
    public void Render_WagonSelection()
    {
        WagonRender render = new WagonRender();
        HashSet<Wagon> wagons = new HashSet<Wagon>(shop.GetAvaliableWagons());
        for (Wagon i : wagons)
        {
            render.RenderWagon(i);
            System.out.println("["+i.hashCode()+"] Price: "); //TODO: get Wagon price 
        }
    }
    public void Render_LocomotiveSelection()
    {
        TrainRender render = new TrainRender();
        HashSet<Locomotive> loco = new HashSet<Locomotive>(shop.GetAvlaiableLocomotives());
        for (Locomotive i : loco)
        {
            render.RenderLocomotive(i.GetLocomotiveType());
            System.out.println("["+i.hashCode()+"] Price: ");
        }
    }
    public void Render_ShopMenu()
    {
        System.out.println("Welcome to Shop!");
        System.out.println("What would you like to buy?");

    }
    public void Render_ShopFuel()
    {
        System.out.println("Shop: buy fuel");
    }
}

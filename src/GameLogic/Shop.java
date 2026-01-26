package GameLogic;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

import GameObjects.Locomotive;
import GameObjects.Wagon;

public class Shop {
    private Vector<Locomotive> availableLocomotives;
    private Vector<Wagon> availableWagons;
    public Shop()
    {
        FileReaderUtils fileReader = new FileReaderUtils();
        HashSet<Locomotive> locomotivesFromFile = fileReader.LoadLocomotives("data/ShopLocomotiveStock.txt");
        HashSet<Wagon> wagonsFromFile = fileReader.LoadWagons("data/ShopWagonStock.txt");
      
        if (locomotivesFromFile.isEmpty())
        {
            System.out.println("Error: Failed to load hasset of locomotives");
            return;
        }
        if (wagonsFromFile.isEmpty())
        {
            System.out.println("Error: Failed to load hasset of locomotives");
            return;
        }
        availableLocomotives = new Vector<Locomotive>(locomotivesFromFile.size());
        availableWagons = new Vector<Wagon>(wagonsFromFile.size());

        availableLocomotives.addAll(locomotivesFromFile);
        availableWagons.addAll(wagonsFromFile);
        


        
    }
    public void BuyFuel(Player player)
    {
        
    };
    public void BuyLocomotive()
    {
        //TODO: Implementation for purchasing a locomotive
    };
    public void BuyWagon()
    {
        //TODO: Implementation for purchasing a wagon
    };
    public Vector<Wagon>GetAvaliableWagons()
    {
        return availableWagons;
    }
    public Vector<Locomotive>GetAvlaiableLocomotives()
    {
        return availableLocomotives;
    }

    
}

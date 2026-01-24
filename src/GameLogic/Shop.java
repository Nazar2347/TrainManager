package GameLogic;
import java.util.HashSet;

import GameObjects.Locomotive;
import GameObjects.Wagon;

public class Shop {
    private Player player;
    private HashSet<Locomotive> availableLocomotives;
    private HashSet <Wagon> availableWagons;
    public Shop()
    {
       FileReaderUtils fileReader = new FileReaderUtils();
       availableLocomotives = fileReader.LoadLocomotives("data/ShopLocomotiveStock");
       availableWagons = fileReader.LoadWagons("data/ShopWagonStock");
        
    }
    public void BuyFuel()
    {
        //TODO: Implementation for buying fuel and refueling locomotives
    };
    public void BuyLocomotive()
    {
        //TODO: Implementation for purchasing a locomotive
    };
    public void BuyWagon()
    {
        //TODO: Implementation for purchasing a wagon
    };
    public HashSet<Wagon>GetAvaliableWagons()
    {
        return availableWagons;
    }
    public HashSet<Locomotive>GetAvlaiableLocomotives()
    {
        return availableLocomotives;
    }

    
}

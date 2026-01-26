package GameLogic;

import java.util.HashSet;
import java.util.Vector;

import GameObjects.Locomotive;
import GameObjects.Cart;
import GameObjects.Wagon;


public class Player 
{
    private int moneyBalance;
    private String playerName;
    private HashSet<Locomotive> ownedLocomotives;
    private HashSet<Wagon> ownedWagons;
    private Locomotive currentLocomotive;

    public Player(String name, int startingBalance)
    {
        this.playerName = name;
        this.moneyBalance = startingBalance;
        this.ownedLocomotives = new HashSet<Locomotive>();
        this.ownedWagons = new HashSet<Wagon>();
    }
    public int GetMoneyBalance()
    {
        return moneyBalance;
    }
    public void SetMoneyBalance(int newBalance)
    {
        moneyBalance = newBalance;
    }
    public String getName()
    {
        return playerName;
    }
    public void Input_Drive()
    {

    };
    public void SetCurrenntLocomotive(Locomotive loco)
    {
        currentLocomotive = loco;
    };
    public void AddLocomotiveToInventory(Locomotive loco)
    {
        ownedLocomotives.add(loco);
    };
    public HashSet<Locomotive> GetOwnedLocomotives()
    {
        return ownedLocomotives;
    };
    public HashSet<Wagon> GetOwnedWagons()
    {
        return ownedWagons;
    };
    public Locomotive getCurrentLocomotive()
    {
        return currentLocomotive;
    }
    public Vector<Cart> getCurrentWagonSet()
    {
        return currentLocomotive.GetAttachedWagons();
    }
    public void RemoveLocomotiveFromInventory(Locomotive loco)
    {
        ownedLocomotives.remove(loco);
    };
    public void RemoveWagonFromInventory(Wagon wagon)
    {
        ownedWagons.remove(wagon);
    };
    public void AddWagonToInventory(Wagon wagon)
    {
        ownedWagons.add(wagon);
    };
    public void AddWagonSetToInventory(HashSet<Wagon> wagons)
    {
        this.ownedWagons.addAll(wagons);
    };
    public void AddLocomotiveSetToInventory(HashSet<Locomotive> locomotives)
    {
        this.ownedLocomotives.addAll(locomotives);
    };
    public boolean AddWagonsToWagonSet(Wagon wag)
    {
      if (currentLocomotive == null)
      {
        return false;
      }
      return currentLocomotive.AttachWagon(wag);
        
    }
    public void RemoveWagonFromSet(short index)
    {
        if (currentLocomotive == null)
        {
            return;
        }
        currentLocomotive.DetachWagon(index);
    }

    

}
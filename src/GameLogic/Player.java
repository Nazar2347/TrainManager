package GameLogic;

import java.util.HashSet;
import java.util.Vector;

import GameObjects.Locomotive;
import GameObjects.Wagon;
import GameObjects.FreightWagon;
import GameObjects.PassangerWagon;

public class Player 
{
    private int moneyBalance;
    private String playerName;
    private HashSet<Locomotive> ownedLocomotives;
    private HashSet<Wagon> ownedWagons;
    private Locomotive currentLocomotive;
    private Vector<Wagon> wagonsSet;

    public Player(String name, int startingBalance)
    {
        this.playerName = name;
        this.moneyBalance = startingBalance;
        this.ownedLocomotives = new HashSet<Locomotive>();
        this.ownedWagons = new HashSet<Wagon>();
        this.wagonsSet = new Vector<Wagon>();
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
    public Vector<Wagon> getCurrentWagonSet()
    {
        return wagonsSet;
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
    public void AddWagonsToWagonSet(Wagon wag)
    {
        wagonsSet.add(wag);
    }
    public void RemoveWagonFromSet(int index)
    {
        wagonsSet.removeElementAt(index);
    }

    

}
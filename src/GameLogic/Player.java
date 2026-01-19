package GameLogic;

import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public Player(String name, int startingBalance)
    {
        this.playerName = name;
        this.moneyBalance = startingBalance;
        this.ownedLocomotives = new HashSet<Locomotive>();
        this.ownedWagons = new HashSet<Wagon>();
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

    };
    public void AddLocomotiveToInventory(Locomotive loco)
    {

    };
    public HashSet<Locomotive> GetOwnedLocomotives()
    {
        return ownedLocomotives;
    };
    public HashSet<Wagon> GetOwnedWagons()
    {
        return ownedWagons;
    };

    public void RemoveLocomotiveFromInventory(Locomotive loco)
    {

    };
    public void AddWagonToInventory(Wagon wagon)
    {
    };
    public void RemoveWagonFromInventory(Wagon wagon)
    {

    };
    public void AddWagonSetToInventory(HashSet<Wagon> wagons)
    {
        this.ownedWagons.addAll(wagons);
    };
    public void AddLocomotiveSetToInventory(HashSet<Locomotive> locomotives)
    {
        this.ownedLocomotives.addAll(locomotives);
    };

    

}
package GameObjects;
import GameLogic.Player;
import java.util.Vector;
import java.util.List;

public class Locomotive extends Cart {
private String driverName;
private E_LocomotiveType type;
private float fuelCapacity;
private float currentFuelLevel;
private float fuelConsumptionRate; // fuel consumed per unit distance

private Vector<Cart> attachedWagons;
private int maxWagons;
private float maxTowedMass;
private float currentTowedMass;

public Locomotive(String name,E_LocomotiveType locotype, float emptyMass, float maxMass, float fuelCapacity, float fuelConsumptionRate, int maxWagons, float maxTowedMass)
{
    super(name,emptyMass, maxMass);
    this.type =locotype;
    this.fuelCapacity = fuelCapacity;
    this.currentFuelLevel = fuelCapacity; // Start with full tank
    this.fuelConsumptionRate = fuelConsumptionRate;
    this.maxWagons = maxWagons;
    this.maxTowedMass = maxTowedMass;
    this.attachedWagons = new Vector<Cart>();
}

public E_LocomotiveType GetLocomotiveType()
{
    return this.type;
}
public boolean Input_Drive()
{
    if (currentFuelLevel <= 0)
    {
        System.out.println("Locomotive is out of fuel.");
        //TODO: Add logic to go shop fuel
        return false;
    }
    ConsumeFuel();
    return true;

};
public void Refuel()
{
    currentFuelLevel = fuelCapacity;
};
public float GetFuelCapacityLevel()
{
    return fuelCapacity;
}
public float GetCurrentFuelLevel()
{
    return currentFuelLevel;
}
private void ConsumeFuel()
{
    float summWeight=0;
    if (attachedWagons == null)
    {
        summWeight = this.currentMass;
    }
    else 
    {
        for (Cart i : attachedWagons)
        {   
            summWeight +=i.currentMass;
        }
        summWeight +=this.currentMass;
    }
    currentFuelLevel-= summWeight/100;
};
public boolean AttachWagon(Wagon wagon)
{
    if (attachedWagons.size() >= maxWagons) {
        System.out.println("Cannot attach more wagons: maximum limit reached.");
        return false;
    }
    if (currentTowedMass + wagon.GetMass() > maxTowedMass) {
        System.out.println("Cannot attach wagon: exceeding maximum towed mass.");
        return false;
    }
    attachedWagons.add(wagon);
    currentTowedMass += wagon.GetMass();
    return true;
};
public void DetachWagon(short wagonIndex)
{
    if (attachedWagons.isEmpty()) {
        System.out.println("No wagons to detach.");
        return;
    }
    if (wagonIndex < 0 || wagonIndex >= attachedWagons.size()) {
        System.out.println("Invalid wagon index.");
        return;
    }
    Cart wagon = attachedWagons.get(wagonIndex);
    attachedWagons.remove(wagonIndex);
    currentTowedMass -= wagon.GetMass();
};
public String getName()
{
   return name;
};

public Vector<Cart> GetAttachedWagons()
{
    return attachedWagons;
}
public void OnBeginPlay()
{
//TODO: Initialization code when the locomotive is created
};
public void OnDestroy()
{
 //TODO: Cleanup object when the locomotive is destroyed
};
}

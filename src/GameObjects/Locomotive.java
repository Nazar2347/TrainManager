package GameObjects;
import GameLogic.Player;
import java.util.List;

public class Locomotive extends Cart {
private String driverName;
private E_LocomotiveType type;
private float fuelCapacity;
private float currentFuelLevel;
private float fuelConsumptionRate; // fuel consumed per unit distance

private List<Wagon> attachedWagons;
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
    this.attachedWagons = new java.util.ArrayList<Wagon>();
}
public void SetDriver(Player player)
{
    this.driverName = player.getName();
}
public void RemoveDriver()
{
    this.driverName = null;
}
public E_LocomotiveType GetLocomotiveType()
{
    return this.type;
}
public void Input_Drive()
{
    if(driverName ==null)
    {
        System.out.println("No driver assigned to the locomotive.");
        return;
    }
    if (currentFuelLevel <= 0)
    {
        System.out.println("Locomotive is out of fuel.");
        //Add logic to direct switch state to shop or Lose
        return;
    }

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
//TODO: Implementation for fuel consumption during driving
};
private void AttachWagon(Wagon wagon)
{
    if (attachedWagons.size() >= maxWagons) {
        System.out.println("Cannot attach more wagons: maximum limit reached.");
        return;
    }
    if (currentTowedMass + wagon.GetMass() > maxTowedMass) {
        System.out.println("Cannot attach wagon: exceeding maximum towed mass.");
        return;
    }
    attachedWagons.add(wagon);
    currentTowedMass += wagon.GetMass();
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
    Wagon wagon = attachedWagons.get(wagonIndex);
    attachedWagons.remove(wagonIndex);
    currentTowedMass -= wagon.GetMass();
};
public String getName()
{
   return name;
};

public void OnBeginPlay()
{
//TODO: Initialization code when the locomotive is created
};
public void OnDestroy()
{
 //TODO: Cleanup object when the locomotive is destroyed
};
}

package GameObjects;

public class Locomotive extends Cart {
private String driverName;
private float fuelCapacity;
private float currentFuelLevel;
private float fuelConsumptionRate; // fuel consumed per unit distance

private Wagon[] attachedWagons;
private int maxWagons;
private float maxTowedMass;

public void Input_Drive(){
 //TODO: Implementation for driving the locomotive    
};
public void Refuel(float amount){
    //TODO: Implementation for refueling the locomotive
};
private void ConsumeFuel(){
//TODO: Implementation for fuel consumption during driving
};
private void AttachWagon(Wagon wagon){
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

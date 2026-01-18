package GameObjects;

public class PassangerWagon extends Wagon {

    PassangerWagon(float emptyMass, float maxMass)
    {
        super(emptyMass, maxMass);
    }
    @Override
    protected void LoadCargo(Cargo cargo) 
    {
       Passengers passengers = (Passengers) cargo;
         if (currentMass + passengers.getNumberOfPassengers() > maxMass) {
              System.out.println("Cannot load passengers: exceeding maximum mass.");
              return;
         }
        loadedCargo.add(cargo);
        currentMass += passengers.GetMass();
        
    };
    @Override
    protected void UnloadCargo() 
    {
        if (loadedCargo.isEmpty()) {
            System.out.println("No passengers to unload.");
            return;
        }
        for (Cargo cargo : loadedCargo) {
            currentMass -= cargo.GetMass();
        }
        loadedCargo.clear();
    };
}

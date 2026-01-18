package GameObjects;

public class FreightWagon extends Wagon {

    public FreightWagon(float emptyMass, float maxMass) {
        super(emptyMass, maxMass);
    }

    @Override
    protected void LoadCargo(Cargo cargo) {
        if (currentMass + cargo.GetMass() > maxMass) {
            System.out.println("Cannot load cargo: exceeding maximum mass.");
            return;
        }
        loadedCargo.add(cargo);
        currentMass += cargo.GetMass();

    }

    @Override
    protected void UnloadCargo() {
        if (loadedCargo.isEmpty()) {
            System.out.println("No cargo to unload.");
            return;
        }
        for (Cargo cargo : loadedCargo) {
            currentMass -= cargo.GetMass();
        }
        loadedCargo.clear();
    }
}

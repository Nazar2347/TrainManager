package GameObjects;

public class FreightWagon extends Wagon {

    protected E_WagonType type;
    public FreightWagon(String name,E_WagonType wagonType, float emptyMass, float maxMass) {
        super(name, emptyMass, maxMass);
        this.type = wagonType;
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
    public E_WagonType getFreighType()
    {
        return type;
    }
}

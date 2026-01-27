package GameObjects;

public class FreightCargo extends Cargo {
private E_CargoType cargoType;
    

    @Override
    public String getName() {
        return cargoType.toString() + " Cargo";
    }
    public FreightCargo(float mass,E_CargoType cargoType) {
        super(mass);
        this.cargoType = cargoType;
    }
    
    public E_CargoType getCargoType() {
        return cargoType;
    }
}

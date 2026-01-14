package GameObjects;

public class FreightCargo extends Cargo {
private E_CargoType cargoType;
    
    public FreightCargo(E_CargoType cargoType) {
        this.cargoType = cargoType;
    }
    
    public E_CargoType getCargoType() {
        return cargoType;
    }
}

package GameObjects;
  
import java.util.HashSet;

public abstract class Wagon extends Cart
 {
    
    protected HashSet<Cargo> loadedCargo;
    public Wagon(String name, float emptyMass, float maxMass)
    {
        super(name, emptyMass, maxMass);
    };
    
    
    protected abstract void LoadCargo(Cargo cargo);

    protected abstract void UnloadCargo();
}
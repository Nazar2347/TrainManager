package GameObjects;
  
import java.util.HashSet;

public abstract class Wagon extends Cart
 {
    
    protected HashSet<Cargo> loadedCargo;
    public Wagon(float emptyMass, float maxMass)
    {
        super(emptyMass, maxMass);
    };
    
    
    protected abstract void LoadCargo(Cargo cargo);

    protected abstract void UnloadCargo();
}
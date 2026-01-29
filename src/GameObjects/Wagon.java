package GameObjects;
  
import java.util.List;

public abstract class Wagon extends Cart
 {
    
    protected List<Cargo> loadedCargo;
    
    public Wagon(String name,float emptyMass, float maxMass)
    {
        super(name, emptyMass, maxMass);
        
    };
    
    public List<Cargo> GetCargo()
    {
        return loadedCargo;
    }
    
    public abstract void LoadCargo(Cargo cargo);

    public abstract void UnloadCargo();
}
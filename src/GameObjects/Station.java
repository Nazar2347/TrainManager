package GameObjects;

public abstract class Station {
protected String name;
protected float totalCargoMass;
protected int location;

    public Station(String name,int location)
    {
        this.name = name;
        this.location = location;
    }
    public String GetName()
    {
        return name;
    }
    public void  LoadCargo()
    {
        
    };
    public void UnloadCargo()
    {

    };

    public int getLocation()
    {
        return location;
    };
}

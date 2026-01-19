package GameObjects;

public abstract class Cart implements Object {
    protected float emptyMass;
    protected float maxMass;
    protected float currentMass;
    protected String name;

    @Override
    public String getName()
    {
        return name;
    }
    public Cart(String name, float emptyMass, float maxMass)
    {
        this.name = name;
        this.emptyMass = emptyMass;
        this.maxMass = maxMass;
        this.currentMass = emptyMass;
    }
    public float GetMass()
    {
        return currentMass;
    }
}

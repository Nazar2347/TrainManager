package GameObjects;

public abstract class Cart implements Object {
    protected float emptyMass;
    protected float maxMass;
    protected float currentMass;

    public Cart(float emptyMass, float maxMass)
    {
        this.emptyMass = emptyMass;
        this.maxMass = maxMass;
        this.currentMass = emptyMass;
    }
    public float GetMass()
    {
        return currentMass;
    }
}

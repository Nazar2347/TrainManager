package GameObjects;

public class Passengers extends Cargo 
{
    private String destination;
    private int numberOfPassengers;


    
    public Passengers(String destination, int numberOfPassengers) {
        this.destination = destination;
        this.mass= numberOfPassengers * 70; // Assuming average mass per passenger is 70 kg
    }
    
    
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public String getDestination() {
        return destination;
    }
}

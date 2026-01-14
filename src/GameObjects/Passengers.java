package GameObjects;

public class Passengers extends Cargo {
private String destination;
    
    public Passengers(String destination) {
        this.destination = destination;
    }
    
    public String getDestination() {
        return destination;
    }
}

package GameLogic;
import GameObjects.Cargo;
import GameObjects.Station;

public class GameTask {
    private Station stationA;
    private Station stationB;
    private Cargo[] cargoRequired;
    private int distance;
    private int distancePassed;
    private int rewardPoints;

    public GameTask(Station stationA, Station stationB, Cargo[] cargoRequired, int rewardPoints) {
        this.stationA = stationA;
        this.stationB = stationB;
        this.cargoRequired = cargoRequired;
        this.rewardPoints = rewardPoints;
        this.distancePassed =0;


        int furthestStation = Math.max(stationA.getLocation(), stationB.getLocation());
        int closestStation = Math.min(stationA.getLocation(), stationB.getLocation());
        this.distance = furthestStation - closestStation;

    };
    public GameTask(Station stationA, Station stationB)
    {
        this.stationA = stationA;
        this.stationB = stationB;

        int furthestStation = Math.max(stationA.getLocation(), stationB.getLocation());
        int closestStation = Math.min(stationA.getLocation(), stationB.getLocation());
        this.distance = furthestStation - closestStation;
    }
    public boolean tryCompleteTask() {

        if (distancePassed < distance)
        {
            distancePassed++;
            return false;
        }
        System.out.print("You arrived to Station: "+stationB.GetName());
        distancePassed = 0;
        if (calculateDeliveredCargo())
        {
            System.out.println("You suceefuly deliver all required cargo!");
            return true;
        }
       
        System.out.println(" not enough cargo were delivered!");
        return false;
        

    };
    public int GetDistanceLeft()
    {
        return distance - distancePassed;
    }
    public boolean calculateDeliveredCargo()
    {
        //TODO: calculate DeliverdCargo
        return false;
    }
    public int GetDistanceBetweenStation()
    {
        return distance;
    }
}

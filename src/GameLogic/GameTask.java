package GameLogic;
import GameObjects.Cargo;
import GameObjects.Station;

public class GameTask {
private Station stationA;
private Station stationB;
private Cargo[] cargoRequired;

private int rewardPoints;
public GameTask(Station stationA, Station stationB, Cargo[] cargoRequired, int rewardPoints) {
    this.stationA = stationA;
    this.stationB = stationB;
    this.cargoRequired = cargoRequired;
    this.rewardPoints = rewardPoints;
};
public void completeTask() {
    //TODO: Logic to complete the task
};
public void calculateDeliveredCargo()
{
    //TODO: Logic to calculate delivery
}
}

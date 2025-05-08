import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {
    private static final ParkingGarage instance = new ParkingGarage();

    private List<Vehicle> vehiclesList = new ArrayList<>();
    private int totalCapacity = 60;


    public static ParkingGarage getInstance() {
        return instance;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void lowerCapacity(){
        totalCapacity--;
    }

    public void increaseCapacity(){
        totalCapacity++;
    }


    public void add(Vehicle vehicle) {
        vehiclesList.add(vehicle);
        totalCapacity--;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }
}

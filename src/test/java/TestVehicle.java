import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestVehicle {
    @Test
    public void testVehicleAdditionToParkingGarage() {
        // this test the parking garage if a vehicle is added it want to make sure that the vehicle is added to the list
        // of vehicles inside tha class and making sure the size increases
        ParkingGarage parking = new ParkingGarage();

        List<Vehicle> testList = parking.getVehiclesList();
        int initialCapacity = testList.size();

        Vehicle vehicle = new Vehicle("1234", "nissan", "altima", 2020, "black");
        parking.add(vehicle);

        assertEquals(initialCapacity + 1, parking.getVehiclesList().size());
    }
}


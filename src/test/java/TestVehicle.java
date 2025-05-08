import org.junit.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testVehicleCreation() {
        Vehicle v = new Vehicle("ABC123", "Toyota", "Camry", 2020, "Red");
        assertEquals("ABC123", v.getLicense());
        assertEquals("Toyota", v.getMake());
        assertEquals("Camry", v.getModel());
        assertEquals("2020", v.getYear());
        assertEquals("Red", v.getColor());
    }

    @Test
    public void testEntryTimeIsSetOnCreation() {
        Vehicle v = new Vehicle("XYZ789", "Honda", "Civic", 2021, "Blue");
        Instant now = Instant.now();
        assertTrue(v.getTime().isBefore(now.plusSeconds(2)));
        assertTrue(v.getTime().isAfter(now.minusSeconds(2)));
    }

    @Test
    public void testGetTimeAsStringOutput() {
        Vehicle v = new Vehicle("XYZ789", "Honda", "Civic", 2021, "Blue");
        String result = v.getTimeAsString();
        assertTrue(result.contains("You entry time was"));
        assertTrue(result.contains("the Current Time is"));
    }

    @Test
    public void testGarageContainsVehicleAfterAdd() {
        ParkingGarage garage = ParkingGarage.getInstance();
        Vehicle v = new Vehicle("AAA111", "Ford", "Focus", 2019, "Black");
        garage.add(v);
        assertTrue(garage.getVehiclesList().contains(v));
    }

    @Test
    public void testIncreaseAndDecreaseCapacity() {
        ParkingGarage garage = ParkingGarage.getInstance();
        int before = garage.getTotalCapacity();
        garage.lowerCapacity();
        assertEquals(before - 1, garage.getTotalCapacity());
        garage.increaseCapacity();
        assertEquals(before, garage.getTotalCapacity());
    }

}


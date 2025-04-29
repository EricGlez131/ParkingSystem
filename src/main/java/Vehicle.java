import java.time.Instant;


public class Vehicle {
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    private String Color;
    private Instant entryTime;

    public Vehicle(String licensePlate, String make, String model, int year, String Color) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.Color = Color;
        this.entryTime = Instant.now();
    }


    public Instant getTime(){
        return entryTime;
    }


    public String getLicense() {
        return licensePlate;
    }
}

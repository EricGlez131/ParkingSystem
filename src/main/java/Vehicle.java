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

    public String getTimeAsString(){
        double totalTime = Instant.now().toEpochMilli() - entryTime.toEpochMilli();
        String time = "You entry time was" +  entryTime.toString() + "the Current Time is " + Instant.now();
        return time;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return Color;
    }

    public String getYear() {
        return year + "";
    }
}

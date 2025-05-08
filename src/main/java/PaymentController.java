import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class PaymentController {

    public TextField promptText;

    public void handlePayment(ActionEvent event) {
        String licensePlate = promptText.getText().trim();

        ParkingGarage parkingGarage = ParkingGarage.getInstance();
        List<Vehicle> vehicleList = parkingGarage.getVehiclesList();

        if (licensePlate == null || licensePlate == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please enter a valid license plate");
        }

        Vehicle match = null;
        for (Vehicle vehicle : vehicleList) {
            if (licensePlate.equalsIgnoreCase(vehicle.getLicense())) {
                match = vehicle;

                break;
            }
        }

        if (match != null) {
            Instant now = Instant.now();
            long durationMillis = now.toEpochMilli() - match.getTime().toEpochMilli();
            System.out.println(durationMillis);
            long minutes = durationMillis / (1000 * 60);

            double ratePerMinute = 0.05;
            double totalOwed = minutes * ratePerMinute + 10; // 10 is for starting fee

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Payment Due");
            alert.setHeaderText("Vehicle Found: " + match.getLicense());
            alert.setContentText("Parked Time: " + minutes + " minutes\n" +
                    "Amount Due: $" + String.format("%.2f", totalOwed) + "\nPlease head to the Payment house with receipt to pay");
            alert.showAndWait();

            printReceipt(match, totalOwed);

            parkingGarage.getVehiclesList().remove(match);
            System.out.println("The vehicle" + match.getLicense() + " has been deleted from the Parking Garage reference" +
                    "once this piece of code is done the match reference will be cleared by garbage collection");
        }


    }

    private void printReceipt(Vehicle match, double totalOwed) {
        String fileName = "receipt.txt";

        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write("----- Parking Receipt -----\n");
            writer.write("License Plate: " + match.getLicense() + "\n");
            writer.write("Make: " + match.getMake() + "\n");
            writer.write("Model: " + match.getModel() + "\n");
            writer.write("Color: " + match.getColor() + "\n");
            writer.write("Year: " + match.getYear() + "\n");
            writer.write("Entry Time: " + match.getTime() + "\n");
            writer.write("Exit Time: " + java.time.Instant.now() + "\n");

            long durationMillis = java.time.Instant.now().toEpochMilli() - match.getTime().toEpochMilli();
            long minutes = durationMillis / (1000 * 60);
            writer.write("Total Time Parked: " + minutes + " minutes\n");
            writer.write("Amount Due: $" + String.format("%.2f", totalOwed) + "\n");
            writer.write("---------------------------\n");
            System.out.println("Receipt created: " + fileName);
        } catch (java.io.IOException e) {
            System.err.println("Failed to create receipt: " + e.getMessage());
        }

    }


    public void Back(ActionEvent actionEvent) throws IOException {
        Parent mainRoot = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(mainRoot));
        stage.setHeight(400);
        stage.setWidth(300);
        stage.show();
    }

}

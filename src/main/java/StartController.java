import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    @FXML
    private TextField license, color, make, model, year;

    @FXML
    public void Submit(ActionEvent actionEvent){
        //public Vehicle(String licensePlate, String make, String model, int year, String Color) {
        int intYear = Integer.parseInt(year.getText());
        Vehicle vehicle = new Vehicle(license.getText(), make.getText(), model.getText(), intYear, color.getText());


        ParkingGarage parkingGarage = ParkingGarage.getInstance();
        parkingGarage.add(vehicle);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Parking garage");
        alert.setHeaderText("You have successfully added your car to the parking garage");
        alert.setContentText("Please place your " + vehicle.getLicense() + " In the parking spot, Thank You");
        alert.showAndWait();

        resetStartGUI();

    }

    private void resetStartGUI() {
        license.clear();
        make.clear();
        model.clear();
        year.clear();
        color.clear();
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

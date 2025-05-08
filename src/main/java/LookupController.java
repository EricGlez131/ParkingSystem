import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class LookupController {
    public Label displayLabel;
    public TextField lookUpField;


    public void search(ActionEvent actionEvent) {
        System.out.println("search");
        String toLookUp =  lookUpField.getText();

        ParkingGarage parkingGarage = ParkingGarage.getInstance();
        List<Vehicle> vehicles = parkingGarage.getVehiclesList();

        for (Vehicle vehicle : vehicles) {
            if(vehicle.getLicense().equals(toLookUp)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Parking garage");
                alert.setHeaderText("You Vehicle with License: " + vehicle.getLicense() + " If in the parking garage ");
                alert.setContentText("If you would like to pay end stay or pay for the time please head into 'End / Payment'");
                alert.showAndWait();
                toLookUp = "";
                break;
            }

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

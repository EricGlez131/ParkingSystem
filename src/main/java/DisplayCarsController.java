import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class DisplayCarsController {

    public Label stringLabel;

    @FXML
    public void initialize() {
        StringBuilder stringToDisplay = new StringBuilder();
        ParkingGarage parkingGarage = ParkingGarage.getInstance();
        List<Vehicle> vehicleList = parkingGarage.getVehiclesList();
        if (parkingGarage.getTotalCapacity() < 60) {
            for (Vehicle vehicle : vehicleList) {
                stringToDisplay.append(vehicle.getLicense());
            }
            stringLabel.setText(stringToDisplay.toString());
        }
       else {
           stringLabel.setText("There are currently no car \n parked in this garage");
        }



        
    }


    public void Back(ActionEvent actionEvent) throws IOException {
        Parent mainRoot = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(mainRoot));
        stage.setHeight(400);
        stage.setWidth(300);
        stage.show();
    }
}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML
    private VBox root;


    @FXML
    private void Lookup(ActionEvent actionEvent) throws IOException {
        VBox pane = FXMLLoader.load(getClass().getResource("/Lookup.fxml"));
        root.getChildren().setAll(pane);
    }

    public void startSession(ActionEvent actionEvent) throws IOException {
        VBox pane = FXMLLoader.load(getClass().getResource("/Start.fxml"));
        root.getChildren().setAll(pane);
    }

    public void PaymentNend(ActionEvent actionEvent) throws IOException {
        VBox pane = FXMLLoader.load(getClass().getResource("/Payment.fxml"));
        root.getChildren().setAll(pane);
    }

    public void displayCar(ActionEvent actionEvent) throws IOException {
        VBox pane = FXMLLoader.load(getClass().getResource("/DisplayCars.fxml"));
        root.getChildren().setAll(pane);
    }
}
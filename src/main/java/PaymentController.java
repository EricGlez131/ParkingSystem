import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {



    public void Back(ActionEvent actionEvent) throws IOException {
        Parent mainRoot = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(mainRoot));
        stage.setHeight(400);
        stage.setWidth(300);
        stage.show();
    }

}

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void OpenRPS(ActionEvent event) throws IOException{
        switchScene(event, "RPSWind.fxml");
    }


    @FXML
    public void OpenTTT(ActionEvent event) throws IOException{
        switchScene(event, "TTTWind.fxml");
    }
}
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RPSController {
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
    public void PlayRock(ActionEvent event) throws IOException{
        int r = (int)((Math.random() * 3) + 1);
        if(r==1){
            switchScene(event, "TieWind.fxml");
        }
        if(r==2){
            switchScene(event, "LossWind.fxml");
        }
        if(r==3){
            switchScene(event, "VictoryWind.fxml");
        }
    }

    @FXML
    public void PlayPaper(ActionEvent event) throws IOException{
        int r = (int)((Math.random() * 3) + 1);
        if(r==1){
            switchScene(event, "VictoryWind.fxml");
        }
        if(r==2){
            switchScene(event, "TieWind.fxml");
        }
        if(r==3){
            switchScene(event, "LossWind.fxml");
        }
    }

    @FXML
    public void PlayScissors(ActionEvent event) throws IOException{
        int r = (int)((Math.random() * 3) + 1);
        if(r==1){
            switchScene(event, "LossWind.fxml");
        }
        if(r==2){
            switchScene(event, "VictoryWind.fxml");
        }
        if(r==3){
            switchScene(event, "TieWind.fxml");
        }
    }
}

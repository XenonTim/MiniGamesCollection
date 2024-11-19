import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.Random;
public class TTTController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private char[][] board = new char[3][3];
    private boolean PlayerTurn=true;

    @FXML
    private Button A1, B1, C1, A2, B2, C2, A3, B3, C3;

    @FXML
    public void initialize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '\0';
            }
        }
        A1.setOnAction(event -> PlayerMove(0, 0, A1));
        B1.setOnAction(event -> PlayerMove(0, 1, B1));
        C1.setOnAction(event -> PlayerMove(0, 2, C1));
        A2.setOnAction(event -> PlayerMove(1, 0, A2));
        B2.setOnAction(event -> PlayerMove(1, 1, B2));
        C2.setOnAction(event -> PlayerMove(1, 2, C2));
        A3.setOnAction(event -> PlayerMove(2, 0, A3));
        B3.setOnAction(event -> PlayerMove(2, 1, B3));
        C3.setOnAction(event -> PlayerMove(2, 2, C3));
    }
    @FXML
    public void PlayerMove(int row, int col, Button button){
        if(!PlayerTurn || board[row][col]!='\0') return;
        board[row][col]='X';
        button.setText("X");
        if(Check('X')){
            try{
                switchScene("VictoryWind.fxml");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(BoardFull()){
            try {
                switchScene("TieWind.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PlayerTurn = false;
        ComputerMove();
    }

    public void ComputerMove(){
        Random r = new Random();
        int row, col;
        do{
            row = r.nextInt(3);
            col = r.nextInt(3);
        }while (board[row][col] != '\0');
        board[row][col]='O';
        Button button = getButton(row, col);
        if (button != null) {
            button.setText("O");
        }
        if(Check('O')){
            try{
                switchScene("LossWind.fxml");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(BoardFull()){
            try {
                switchScene("TieWind.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PlayerTurn = true;
    }

    private Button getButton(int row, int col) {
        if (row == 0 && col == 0) return A1;
        if (row == 0 && col == 1) return B1;
        if (row == 0 && col == 2) return C1;
        if (row == 1 && col == 0) return A2;
        if (row == 1 && col == 1) return B2;
        if (row == 1 && col == 2) return C2;
        if (row == 2 && col == 0) return A3;
        if (row == 2 && col == 1) return B3;
        if (row == 2 && col == 2) return C3;
        return null;
    }

    public boolean Check(char symbol){
        for(int i = 0; i < 3; i++){
            if(board[i][0]==symbol && board[i][1]==symbol && board[i][2]==symbol)return true;
            if(board[0][i]==symbol && board[1][i]==symbol && board[2][i]==symbol)return true;
        }
        return (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol)||(board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol);
    }

    public boolean BoardFull(){
        for(int row = 0; row<3; row++){
            for(int col = 0; col<3; col++){
                if(board[row][col]=='\0')return false;
            }
        }
        return true;
    }

    @FXML
    public void switchScene(String fxmlFile){
        try{
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) A1.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
}

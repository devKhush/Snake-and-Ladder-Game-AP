package sample.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    @FXML
    private ImageView image;

    @FXML
    private Button startButton;

    @FXML
    private TextField tfTitle1;

    @FXML
    private TextField tfTitle2;

    @FXML
    private Stage snakeAndLadderGameStage;

    private SnakeAndLadderGame snakeAndLadderGame;

    @FXML
    public void btnOKclicked(ActionEvent event) throws IOException {
        Stage mainWindow = (Stage) tfTitle1.getScene().getWindow();
        String player1Name = tfTitle1.getText();
        String player2Name = tfTitle2.getText();
        if (player1Name.equals(""))
            player1Name = "Player1";
        if (player2Name.equals(""))
            player2Name = "Player2";
        mainWindow.setTitle(player1Name+" vs "+player2Name);
        mainWindow.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../SnakeAndLadderGame.fxml"));
        Parent root = loader.load();
        snakeAndLadderGame = loader.getController();
        snakeAndLadderGame.setPlayer1Name(player1Name);
        snakeAndLadderGame.setPlayer2Name(player2Name);
        Image image = new Image(getClass().getResource("../assets/snake.png").toExternalForm());
        snakeAndLadderGameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        snakeAndLadderGameStage.getIcons().add(image);
        snakeAndLadderGameStage.setTitle("Snake & Ladder : '"+player1Name+"' vs '"+player2Name+"'");
        snakeAndLadderGameStage.setScene(new Scene(root));
        snakeAndLadderGameStage.setResizable(false);
        //snakeAndLadderGameStage.setMaximized(true);
        snakeAndLadderGameStage.show();

//        snakeAndLadderGameStage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("../SnakeAndLadderGame.fxml"));
//        Image image = new Image(getClass().getResource("../assets/snake.png").toExternalForm());
//        snakeAndLadderGameStage.getIcons().add(image);
//        snakeAndLadderGameStage.setTitle(player1Name+" vs "+player2Name);
//        snakeAndLadderGameStage.setScene(new Scene(root));
//        snakeAndLadderGameStage.setResizable(false);
//        snakeAndLadderGameStage.show();
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.9);
        startButton.setEffect(glow);
    }

    public void removeButtonSkin() {
        Glow glow = new Glow();
        glow.setLevel(0);
        startButton.setEffect(glow);
    }
}
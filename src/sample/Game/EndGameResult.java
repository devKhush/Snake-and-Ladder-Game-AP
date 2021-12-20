package sample.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Player.Player;

import java.io.IOException;

public class EndGameResult {

    private  Player winner;
    private  Player looser;
    private SnakeAndLadderGame gameToBeClose;

    @FXML
    private Text winnerText;
    @FXML
    private Text loserText;
    @FXML
    private Button restartGameButton;
    @FXML
    private Button stopPlayingButton;

    @FXML
    private Stage newGame;

    public  void setWinner(Player winner) {
        this.winner = winner;
    }

    public  void setLooser(Player looser) {
        this.looser = looser;
    }

    public  void setGameToBeClose(SnakeAndLadderGame gameToBeClose) {
        this.gameToBeClose = gameToBeClose;
    }

    public void playAgain(ActionEvent event) throws IOException {
        Stage mainWindow = (Stage) winnerText.getScene().getWindow();
        mainWindow.close();
        Stage gameWindow = (Stage) gameToBeClose.getMovingArrow().getArrow().getScene().getWindow();
        gameWindow.close();
        newGame = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../MainWindow.fxml"));
        Image image = new Image(getClass().getResource("../assets/snake.png").toExternalForm());
        newGame.getIcons().add(image);
        newGame.setTitle("Snakes & Ladders");
        newGame.setScene(new Scene(root));
        newGame.show();
    }

    public void stopPlaying(ActionEvent event) throws IOException {
        Stage mainWindow = (Stage) winnerText.getScene().getWindow();
        mainWindow.close();
        Stage gameWindow = (Stage) gameToBeClose.getMovingArrow().getArrow().getScene().getWindow();
        gameWindow.close();
    }

    public void setRestartGameButtonSkin(){
        Glow glow = new Glow(0.9);
        restartGameButton.setEffect(glow);
    }

    public void removeRestartGameButtonSkin() {
        Glow glow = new Glow(0);
        restartGameButton.setEffect(glow);
    }

    public void setStopPlayingButtonSkin(){
        Glow glow = new Glow(0.9);
        stopPlayingButton.setEffect(glow);
    }

    public void removeStopPlayingButtonSkin() {
        Glow glow = new Glow(0);
        stopPlayingButton.setEffect(glow);
    }

    @FXML
    public void initialize() {
        winnerText.setText("\""+winner.getPlayerName().getTextName().getText()+"\"");
        loserText.setText("Better Luck next time '"+looser.getPlayerName().getTextName().getText()+"'");
    }

}


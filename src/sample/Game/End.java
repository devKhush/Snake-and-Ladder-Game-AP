package sample.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Player.Player;

import java.io.IOException;

public class End {

    private Player winner;
    private Player looser;

    public End(Player winner, Player looser) {
        this.winner = winner;
        this.looser = looser;
    }

    @FXML
    private Text winnerText;
    @FXML
    private Text loserText;
    @FXML
    private Button restart;

    @FXML
    private Stage new_stage;

    public void again(ActionEvent event) throws IOException {
        Stage mainWindow = (Stage) winnerText.getScene().getWindow();
        mainWindow.close();
        new_stage  = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        new_stage.setScene(new Scene(root));
        new_stage.show();
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.9);
        restart.setEffect(glow);
    }

    public void removeButtonSkin() {
        Glow glow = new Glow();
        glow.setLevel(0);
        restart.setEffect(glow);
    }

    @FXML
    public void initialize() {
        winnerText.setText(winner.getName());
        loserText.setText(looser.getName());
    }

}


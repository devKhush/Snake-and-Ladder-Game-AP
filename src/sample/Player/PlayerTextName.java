package sample.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PlayerTextName implements PlayerComponent {
    @FXML
    private Text textName;

    @FXML
    private Player player;

    public PlayerTextName(Player player, Text textName) {
        this.textName = textName;
        this.player = player;
    }

    @Override
    public void glow() {
        Platform.runLater(new AddPlayerEffect<PlayerTextName>(this,true));
    }

    @Override
    public void dim() {
        Platform.runLater(new AddPlayerEffect<PlayerTextName>(this,false));
    }

    public Text getTextName() {
        return textName;
    }

    @Override
    public Player playerOf() {
        return null;
    }
}

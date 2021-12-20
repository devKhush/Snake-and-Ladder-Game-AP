package sample.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PlayerTextName implements PlayerComponent {
    @FXML
    private Text textName;

    private AddPlayerEffect<PlayerTextName> addPlayerEffect;
    @FXML
    private Player player;

    public PlayerTextName(Player player, Text textName) {
        this.textName = textName;
        this.player = player;
    }

    @Override
    public void glow() {
        addPlayerEffect = new AddPlayerEffect<PlayerTextName>(this,true);
        Platform.runLater(addPlayerEffect);
    }

    @Override
    public void dim() {
        addPlayerEffect = new AddPlayerEffect<PlayerTextName>(this,false);
        Platform.runLater(addPlayerEffect);
    }

    public Text getTextName() {
        return textName;
    }

    @Override
    public Player playerOf() {
        return null;
    }
}

package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PlayerTextName implements PlayerComponent{
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
//        Effect glow = new Glow(1.0);
//        textName.setFill(Color.WHITE);
//        textName.setEffect(glow);
//        textName.setUnderline(true);
//        textName.setOpacity(1);
        Platform.runLater(new AddPlayerEffect<PlayerTextName>(this,true));
    }

    @Override
    public void dim() {
//        Effect glow = new Glow(0);
//        textName.setFill(Color.BLACK);
//        textName.setEffect(glow);
//        textName.setUnderline(false);
//        textName.setOpacity(1);
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

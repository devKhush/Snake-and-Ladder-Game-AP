package sample.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PlayerImage implements PlayerComponent{
    @FXML
    private ImageView playerMainImage;
    private AddPlayerEffect<PlayerImage> addPlayerEffect;

    @FXML
    Player player;

    public PlayerImage(Player player, ImageView playerMainImage) {
        this.player = player;
        this.playerMainImage = playerMainImage;
    }

    @Override
    public void glow(){
        addPlayerEffect = new AddPlayerEffect<PlayerImage>(this,true);
        Platform.runLater(addPlayerEffect);
    }

    @Override
    public void dim(){
        addPlayerEffect = new AddPlayerEffect<PlayerImage>(this,false);
        Platform.runLater(addPlayerEffect);
    }

    @Override
    public Player playerOf() {
        return player;
    }

    public ImageView getPlayerImage(){
        return playerMainImage;
    }
}

package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PlayerImage implements PlayerComponent{
    @FXML
    private ImageView playerMainImage;

    @FXML
    Player player;

    public PlayerImage(Player player, ImageView playerMainImage) {
        this.player = player;
        this.playerMainImage = playerMainImage;
    }

    @Override
    public void glow(){
//        Glow glow = new Glow(0.8);
//        playerMainImage.setEffect(glow);
        Platform.runLater(new AddPlayerEffect<PlayerImage>(this,true));
    }

    @Override
    public void dim(){
//        Glow glow = new Glow(0.0);
//        playerMainImage.setEffect(glow);
        Platform.runLater(new AddPlayerEffect<PlayerImage>(this,false));
    }

    @Override
    public Player playerOf() {
        return player;
    }

    public ImageView getPlayerImage(){
        return playerMainImage;
    }
}

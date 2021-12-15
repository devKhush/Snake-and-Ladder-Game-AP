package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PlayerToken {

    @FXML
    private ImageView playerTokenImage;

    Player player;

    public PlayerToken(Player player, ImageView playerTokenImage) {
        this.player = player;
        this.playerTokenImage = playerTokenImage;
    }

    public void glowToken(){
        Glow glow = new Glow(0.8);
        playerTokenImage.setEffect(glow);
    }

    public void dimToken(){
        Glow glow = new Glow(0.0);
        playerTokenImage.setEffect(glow);
    }

    @FXML
    void translatePlayerToken(){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1500), playerTokenImage);
        animate.setToX(player.getPlayerXLocation());
        animate.setToY(player.getPlayerYLocation());
        animate.setAutoReverse(false);
        animate.play();
    }


    public Player getPlayer() {
        return player;
    }
}

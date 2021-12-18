package sample.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PlayerToken implements PlayerComponent {

    @FXML
    private ImageView playerTokenImage;

    @FXML
    private Player player;

    public PlayerToken(Player player, ImageView playerTokenImage) {
        this.player = player;
        this.playerTokenImage = playerTokenImage;
    }

    @Override
    public void glow(){
        Platform.runLater(new AddPlayerEffect<PlayerToken>(this,true));
    }

    @Override
    public void dim(){
        Platform.runLater(new AddPlayerEffect<PlayerToken>(this,false));
    }

    @FXML
    public void translatePlayerToken(){
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println("Thread sleep failed in Translate PlayerToken class...");
        }
        Platform.runLater(new TokenMover(this));
    }

    public ImageView getPlayerTokenImage() {
        return playerTokenImage;
    }

    @Override
    public Player playerOf() {
        return player;
    }
}

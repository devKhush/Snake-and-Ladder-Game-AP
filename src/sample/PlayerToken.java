package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PlayerToken implements PlayerComponent{

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
//        Glow glow = new Glow(0.8);
//        playerTokenImage.setEffect(glow);
        Platform.runLater(new AddPlayerEffect<PlayerToken>(this,true));
    }

    @Override
    public void dim(){
//        Glow glow = new Glow(0.0);
//        playerTokenImage.setEffect(glow);
        Platform.runLater(new AddPlayerEffect<PlayerToken>(this,false));
    }

    @FXML
    void translatePlayerToken(){
        /*TranslateTransition animate = new TranslateTransition(Duration.millis(1500), playerTokenImage);
        animate.setToX(player.getPlayerXLocation());
        animate.setToY(player.getPlayerYLocation());
        animate.setAutoReverse(false);
        animate.play();*/
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println("Thread sleep failed...");
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

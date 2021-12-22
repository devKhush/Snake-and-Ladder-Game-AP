package sample.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class PlayerToken implements PlayerComponent {

    @FXML
    private ImageView playerTokenImage;
    private TokenMover tokenMover;
    private AddPlayerEffect<PlayerToken> addPlayerEffect;

    @FXML
    private Player player;

    public PlayerToken(Player player, ImageView playerTokenImage) {
        this.player = player;
        this.playerTokenImage = playerTokenImage;
    }

    @Override
    public void glow(){
        addPlayerEffect = new AddPlayerEffect<PlayerToken>(this,true);
        Platform.runLater(addPlayerEffect);
    }

    @Override
    public void dim(){
        addPlayerEffect = new AddPlayerEffect<PlayerToken>(this,false);
        Platform.runLater(addPlayerEffect);
    }

    @FXML
    public void translatePlayerToken(){
        tokenMover = new TokenMover(this);
        Platform.runLater(tokenMover);
    }

    public ImageView getPlayerTokenImage() {
        return playerTokenImage;
    }

    @Override
    public Player playerOf() {
        return player;
    }
}

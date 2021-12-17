package sample;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class TokenMover implements Runnable{
    private PlayerToken token;

    public TokenMover(PlayerToken token) {
        this.token = token;
    }

    @Override
    public void run() {
        TranslateTransition animate = new TranslateTransition(Duration.millis(800), token.getPlayerTokenImage());
        animate.setToX(token.playerOf().getPlayerXLocation());
        animate.setToY(token.playerOf().getPlayerYLocation());
        animate.setAutoReverse(false);
        animate.play();
    }
}

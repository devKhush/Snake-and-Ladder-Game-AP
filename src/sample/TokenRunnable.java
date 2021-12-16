package sample;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class TokenRunnable implements Runnable{
    private PlayerToken token;

    public TokenRunnable(PlayerToken token) {
        this.token = token;
    }

    @Override
    public void run() {
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000), token.getPlayerTokenImage());
        animate.setToX(token.playerOf().getPlayerXLocation());
        animate.setToY(token.playerOf().getPlayerYLocation());
        animate.setAutoReverse(false);
        animate.play();
    }
}

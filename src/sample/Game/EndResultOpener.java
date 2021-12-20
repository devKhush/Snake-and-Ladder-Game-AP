package sample.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class EndResultOpener implements Runnable{
    private SnakeAndLadderGame gameToBeEnd;
    private Stage endGame = null;

    public EndResultOpener(SnakeAndLadderGame gameToBeEnd) {
        this.gameToBeEnd = gameToBeEnd;
    }

    @Override
    public void run() {

        endGame = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../EndGameResult.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image(getClass().getResource("../assets/snake.png").toExternalForm());
        endGame.getIcons().add(image);
        endGame.setTitle("Result of Game: '"+gameToBeEnd.getPlayer1().getPlayerName().getTextName().getText()+"' vs '"+gameToBeEnd.getPlayer2().getPlayerName().getTextName().getText()+"'");
        endGame.setScene(new Scene(root));
        endGame.setResizable(false);
        endGame.show();
    }
}

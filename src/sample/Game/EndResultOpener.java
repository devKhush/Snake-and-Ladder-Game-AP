package sample.Game;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class EndResultOpener implements Runnable{
    private SnakeAndLadderGame gameToBeEnd;
    private Stage endGame = null;
    private ActionEvent event;
    private Parent root;

    public EndResultOpener(SnakeAndLadderGame gameToBeEnd, ActionEvent event, Parent root) {
        this.event = event;
        this.gameToBeEnd = gameToBeEnd;
        this.root = root;
    }

    @Override
    public void run() {
        endGame = (Stage)((Node) event.getSource()).getScene().getWindow();
        Image image = new Image(getClass().getResource("../assets/snake.png").toExternalForm());
        endGame.getIcons().add(image);
        endGame.setTitle("Result of Game: '"+gameToBeEnd.getPlayer1().getPlayerName().getTextName()+"' vs '"+gameToBeEnd.getPlayer2().getPlayerName().getTextName()+"'");
        endGame.setScene(new Scene(root));
        endGame.setResizable(false);
        endGame.show();

//        endGame = new Stage();
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("../EndGameResult.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Image image = new Image(getClass().getResource("../assets/snake.png").toExternalForm());
//        endGame.getIcons().add(image);
//        endGame.setTitle("Result of Game: '"+MainWindow.getPlayerNames()[0]+"' vs '"+MainWindow.getPlayerNames()[1]+"'");
//        endGame.setScene(new Scene(root));
//        endGame.setResizable(false);
//        endGame.show();
    }
}

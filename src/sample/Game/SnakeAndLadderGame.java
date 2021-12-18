package sample.Game;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Die.Die;
import sample.Ladder.Ladder;
import sample.Player.Player;
import sample.Snake.Snake;

import java.io.IOException;

public class SnakeAndLadderGame {

    @FXML
    private ImageView dice_image1;
    @FXML
    private ImageView dice_image2;
    @FXML
    private ImageView dice_image3;
    @FXML
    private ImageView dice_image4;
    @FXML
    private ImageView dice_image5;
    @FXML
    private ImageView dice_image6;
    @FXML
    private ImageView rollingDie;

    @FXML
    Button rollButton;
    @FXML
    ImageView diceFaceImage;

    private int count=2;

    // Player's Information in the SnakeAndLadderGame
    @FXML
    private ImageView player2Picture;
    @FXML
    private ImageView player1Picture;
    @FXML
    private Text player1Text;
    @FXML
    private Text player2Text;
    @FXML
    private ImageView player1Token;
    @FXML
    private ImageView player2Token;

    private EndGameResult gameEndGameResultWindow;
    private Stage endGame;
    private GameHandler gameHandler;


    // Players, Die, Ladder and Snake
    private Player player1 ;
    private Player player2 ;
    private Ladder ladder;
    private Snake snake;
    private Die die;
    private boolean isGameOver = false;
    private boolean isRollButtonDisable = false;

    public boolean ifPlayer1Turn(){
        return (count%2)==1;
    }
    public boolean ifPlayer2Turn(){
        return (count%2==0);
    }

    public void rollButtonClicked() throws IOException {
        if ((!isGameOver) && (!isRollButtonDisable)) {
            gameHandler = new GameHandler(player1,player2,this);
            gameHandler.start();
            count++;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.isGameOver = gameOver;
    }

    public Button getRollButton() {
        return rollButton;
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.8);
        rollButton.setEffect(glow);
    }

    public boolean isRollButtonDisable() {
        return isRollButtonDisable;
    }

    public void setRollButtonDisable(boolean rollButtonDisable) {
        isRollButtonDisable = rollButtonDisable;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Snake getSnake() {
        return snake;
    }

    public Die getDie() {
        return die;
    }

    public void removeButtonSkin() {
        Glow glow = new Glow();
        glow.setLevel(0);
        rollButton.setEffect(glow);
    }

    @FXML
    public void initialize() {
        // Instantiate Player 1 and 2;
        player1 = new Player(player1Token, player1Picture, player1Text);
        player2 = new Player(player2Token, player2Picture, player2Text);
        ladder = new Ladder();
        snake = new Snake();
        die = new Die(6,diceFaceImage,dice_image1,dice_image2,dice_image3,dice_image4,dice_image5,dice_image6,rollingDie);

        player1Text.setText(MainWindow.getPlayerNames()[0]);
        player2Text.setText(MainWindow.getPlayerNames()[1]);
        count = 0;
        player1.glowPlayer();
        player2.dimPlayer();
    }

}
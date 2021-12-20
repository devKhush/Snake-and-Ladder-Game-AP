package sample.Game;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.Die.Die;
import sample.Ladder.Ladder;
import sample.Player.Player;
import sample.Snake.Snake;

import javafx.event.ActionEvent;
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
    private ImageView diceFaceImage;
    @FXML
    private ImageView arrow;
    @FXML
    private ImageView arrowImage;
    @FXML
    private Button realRollButton;

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

    private EndGameResult gameEndGameResult = null;
    private GameHandler gameHandler;


    // Players, Die, Ladder and Snake
    private Player player1 ;
    private Player player2 ;
    private Ladder ladder;
    private Snake snake;
    private Die die;
    private RollButton rollButton;
    private MovingArrow movingArrow;
    private boolean isGameOver = false;
    private boolean isRollButtonDisable = false;

    public boolean ifPlayer1Turn(){
        return (count%2)==1;
    }
    public boolean ifPlayer2Turn(){
        return (count%2==0);
    }

    public void rollButtonClicked(ActionEvent event) throws IOException {
        if ((!isGameOver) && (!isRollButtonDisable)) {
            gameHandler = new GameHandler(this,event);
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

    public MovingArrow getMovingArrow() {
        return movingArrow;
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.8);
        realRollButton.setEffect(glow);
    }

    public RollButton getRollButton() {
        return rollButton;
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
        realRollButton.setEffect(glow);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer1Name(String name){
        player1.getPlayerName().getTextName().setText(name);
    }

    public void setPlayer2Name(String name){
        player2.getPlayerName().getTextName().setText(name);
    }

    @FXML
    public void initialize() {
        // Instantiate Player 1 and 2;
        player1 = new Player(player1Token, player1Picture, player1Text);
        player2 = new Player(player2Token, player2Picture, player2Text);
        ladder = new Ladder(this);
        snake = new Snake(this);
        rollButton = new RollButton(realRollButton);
        movingArrow = new MovingArrow(arrow,arrowImage);
        die = new Die(6,diceFaceImage,dice_image1,dice_image2,dice_image3,dice_image4,dice_image5,dice_image6,rollingDie);
        gameEndGameResult = new EndGameResult();

//        player1Text.setText(MainWindow.getPlayerNames()[0]);
//        player2Text.setText(MainWindow.getPlayerNames()[1]);
        count = 0;
        player1.glowPlayer();
        player2.dimPlayer();
        Platform.runLater(new MovingArrowHandler(getMovingArrow(),true));
    }

}
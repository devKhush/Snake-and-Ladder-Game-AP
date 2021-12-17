package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class SnakeAndLadderGame {

    @FXML
    ImageView dice_image1;
    @FXML
    ImageView dice_image2;
    @FXML
    ImageView dice_image3;
    @FXML
    ImageView dice_image4;
    @FXML
    ImageView dice_image5;
    @FXML
    ImageView dice_image6;

    @FXML
    Button roll_button;
    @FXML
    ImageView diceFaceImage;

    int count=2;

    // Player's Information in the SnakeAndLadderGame
    @FXML
    ImageView player2Picture;
    @FXML
    ImageView player1Picture;
    @FXML
    Text player1Text;
    @FXML
    Text player2Text;
    @FXML
    private ImageView player1Token;
    @FXML
    private ImageView player2Token;

    Stage endGame;


    // Player Instantiation
    private Player player1 ;
    private Player player2 ;
    private Ladder ladder;
    private Snake snake;
    private Die die;
    private boolean gameOver = false;

    public boolean ifPlayer1Turn(){
        return (count%2)==0;
    }
    public boolean ifPlayer2Turn(){
        return (count%2==1);
    }

    public void rollButtonClicked() throws IOException {
        if (!gameOver) {
//            if (ifPlayer1Turn()) {
//                player1.rollDie(die);
//                die.setDiceFaceImage(die.getFaceValue());
//                if (ifPlayer1Turn() && player1.isPlayerGameStarted()) {
//                    player1.movePLayer(die.getFaceValue(), ladder, snake);
//
//                }
//                if ((ifPlayer1Turn()) && (!player1.isPlayerGameStarted()) && (die.getFaceValue() == 1)) {
//                    player1.initialMove();
//                }
//                player1.dimPlayer();
//                player2.glowPlayer();
//            }
//
//            else if (ifPlayer2Turn()) {
//                player2.rollDie(die);
//                die.setDiceFaceImage(die.getFaceValue());
//                if (ifPlayer2Turn() && player2.isPlayerGameStarted()) {
//                    player2.movePLayer(die.getFaceValue(), ladder, snake);
//                }
//                if ((ifPlayer2Turn()) && (!player2.isPlayerGameStarted()) && (die.getFaceValue() == 1)) {
//                    player2.initialMove();
//                }
//                player2.dimPlayer();
//                player1.glowPlayer();
//            }

            PlayerHandler playerHandler = new PlayerHandler(player1,player2,this);
            playerHandler.start();

            count++;
            gameOver = player1.isPlayerWon()||player2.isPlayerWon();
            if (gameOver) {
                if (player1.isPlayerWon()) {
                    System.out.println("Player 1 Won");
                }
                else {
                    System.out.println("Player 2 Won");
                }

                endGame = new Stage();            // End can be made as composition in the Game
                Parent root = FXMLLoader.load(getClass().getResource("end.fxml"));
                Image image = new Image(getClass().getResource("assets/snake.png").toExternalForm());
                endGame.getIcons().add(image);
                endGame.setTitle("Result of Game: "+player1.getName()+" vs "+player2.getName());
                endGame.setScene(new Scene(root));
                endGame.show();
            }
        }
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.8);
        roll_button.setEffect(glow);
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
        roll_button.setEffect(glow);
    }

    @FXML
    public void initialize() {
        // Instantiate Player 1 and 2;
        player1 = new Player(player1Token, player1Picture, player1Text);
        player2 = new Player(player2Token, player2Picture, player2Text);
        ladder = new Ladder();
        snake = new Snake();
        die = new Die(6,diceFaceImage,dice_image1,dice_image2,dice_image3,dice_image4,dice_image5,dice_image6);

        player1Text.setText(MainWindow.getPlayerNames()[0]);
        player2Text.setText(MainWindow.getPlayerNames()[1]);
        count = 0;
        player1.glowPlayer();
        player2.dimPlayer();
    }

}
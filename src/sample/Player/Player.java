package sample.Player;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.Die.Die;
import sample.Ladder.Ladder;
import sample.Snake.Snake;

public class Player {

    @FXML
    private PlayerTextName playerName;
    @FXML
    private PlayerToken playerToken;
    @FXML
    private PlayerImage playerPicture;

    private double playerXLocation = 0;
    private double playerYLocation = 0;
    private boolean playerGameStarted = false;
    private boolean playerWon = false;

    public Player(ImageView playerToken, ImageView playerPicture, Text playerName) {
        this.playerPicture = new PlayerImage(this,playerPicture);
        this.playerName = new PlayerTextName(this, playerName);
        this.playerToken = new PlayerToken(this,playerToken);
    }



    @FXML
    public void movePLayer(int byAmount, Ladder ladder, Snake snake){
        double initialXPosition = playerXLocation;

        for (int i=1; i<=byAmount; i++){

//            if (i==1){
//                try {
//                    Thread.sleep(800);
//                } catch (Exception e) {
//                    System.out.println(e);
//                    System.out.println(e.getMessage());
//                    System.out.println("Thread sleep failed in Player class...");
//                }
//            }

            if ((playerYLocation==0) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerXLocation==550) && (playerYLocation==0)){
                    playerYLocation = -55;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation+=55;
                    playerToken.translatePlayerToken();
                }
                if ((playerXLocation==220) && (playerYLocation==0) && (i==byAmount)){
                    ladder.movePlayerUp(this, 275,-110);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-55) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-55) && (playerXLocation==55)){
                    playerYLocation = -110;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation -= 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-55) && (playerXLocation==440) && (i==byAmount)){
                    ladder.movePlayerUp(this,330,-220);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-110) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-110) && (playerXLocation==550)){
                    playerYLocation = -165;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation += 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-110) && (playerXLocation==385) && (i==byAmount)){
                    snake.bitePlayer(this,275,0);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-165) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-165) && (playerXLocation==55) && (i==byAmount) && (((initialXPosition-55)/55)==byAmount)){
                    snake.bitePlayer(this,165,0);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-165) && (playerXLocation==55)){
                    playerYLocation = -220;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation -= 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-165) && (playerXLocation==440) && (i==byAmount)){
                    ladder.movePlayerUp(this,495,-220);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-165) && (playerXLocation==55) && (i==byAmount) && (((initialXPosition-55)/55)==byAmount)){
                    snake.bitePlayer(this,165,0);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-220) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-220) && (playerXLocation==550) && (i==byAmount) && (((550-initialXPosition)/55)==byAmount)){
                    ladder.movePlayerUp(this,495,-330);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-220) && (playerXLocation==550)){
                    playerYLocation = -275;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation += 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-220) && (playerXLocation==110) && (i==byAmount)){
                    ladder.movePlayerUp(this,165,-330);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-220) && (playerXLocation==550) && (i==byAmount) && (((550-initialXPosition)/55)==byAmount)){
                    ladder.movePlayerUp(this,495,-330);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-220) && (playerXLocation==165) && (i==byAmount)){
                    snake.bitePlayer(this,165,-55);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-275) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-275) && (playerXLocation==55)){
                    playerYLocation = -330;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation -= 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-275) && (playerXLocation==385) && (i==byAmount)){
                    snake.bitePlayer(this,550,-165);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-330) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-330) && (playerXLocation==550)){
                    playerYLocation = -385;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation += 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-330) && (playerXLocation==330) && (i==byAmount)){
                    snake.bitePlayer(this,275,-220);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-330) && (playerXLocation==110) && (i==byAmount)){
                    ladder.movePlayerUp(this,55,-440);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-385) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-385) && (playerXLocation==55)){
                    playerYLocation = -440;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation -= 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-385) && (playerXLocation==275) && (i==byAmount)){
                    snake.bitePlayer(this,165,-275);
                    playerToken.translatePlayerToken();
                }
                else if ((playerYLocation==-385) && (playerXLocation==385) && (i==byAmount)){
                    ladder.movePlayerUp(this,495,-495);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation==-440) && (playerXLocation>=55 && playerXLocation<=550)){
                if ((playerYLocation==-440) && (playerXLocation==550)){
                    playerYLocation = -495;
                    playerToken.translatePlayerToken();
                }
                else {
                    playerXLocation += 55;
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation==-440) && (playerXLocation==495) && (i==byAmount)){
                    snake.bitePlayer(this,440,-275);
                    playerToken.translatePlayerToken();
                }
            }

            else if ((playerYLocation == -495) && (playerXLocation >= 385 && playerXLocation <= 550)) {
                playerXLocation -= 55;
                playerToken.translatePlayerToken();
            }
            else if ((playerYLocation == -495) && (playerXLocation >= 55 && playerXLocation <= 385) && ((byAmount*55)<=(initialXPosition-55))) {
                playerXLocation -= 55;
                playerToken.translatePlayerToken();
                if ((playerYLocation == -495) && (playerXLocation == 55) && (i == byAmount) && (((initialXPosition-55)/55)==byAmount)) {
                    playerWon = true;
                    System.out.println("Won...");
                    playerToken.translatePlayerToken();
                }
                if ((playerYLocation == -495) && (playerXLocation == 110) && (i == byAmount)) {
                    snake.bitePlayer(this, 55, -220);
                    playerToken.translatePlayerToken();
                }
            }
        }

    }


    public void initialMove(){
        playerGameStarted = true;
        playerXLocation = 55;
        playerToken.translatePlayerToken();
    }

    public void rollDie(Die die){
        die.roll();
    }

    public void glowPlayer(){
        playerName.glow();
        playerPicture.glow();
        playerToken.glow();
    }

    public void dimPlayer(){
        playerName.dim();
        playerPicture.dim();
        playerToken.dim();
    }

    public PlayerTextName getPlayerName() {
        return playerName;
    }

    public double getPlayerXLocation() {
        return playerXLocation;
    }

    public double getPlayerYLocation() {
        return playerYLocation;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerXLocation(double playerXLocation) {
        this.playerXLocation = playerXLocation;
    }

    public void setPlayerYLocation(double playerYLocation) {
        this.playerYLocation = playerYLocation;
    }

    public boolean isPlayerGameStarted() {
        return playerGameStarted;
    }

}
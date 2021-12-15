package sample;

import javafx.fxml.FXML;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Player {
    private String name;

    @FXML
    private ImageView playerPicture;
    @FXML
    private Text playerText;

    private PlayerToken playerToken;

    private double playerXLocation = 0;
    private double playerYLocation = 0;
    private boolean playerGameStarted = false;
    private boolean playerWon = false;

    public Player(ImageView playerToken, ImageView playerPicture, Text playerText) {
        this.playerPicture = playerPicture;
        this.playerText = playerText;
        this.playerToken = new PlayerToken(this,playerToken);
    }

    @FXML
    public void movePLayer(int byAmount, Ladder ladder, Snake snake){
        double initialXPosition = playerXLocation;

        for (int i=1; i<=byAmount; i++){

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


    public void setName(String name) {
        this.name = name;
        this.playerText.setText(name);
    }

    public void initialMove(){
        playerGameStarted = true;
        playerXLocation = 55;
        playerToken.translatePlayerToken();
    }

    public void rollDie(Die die){
        die.roll();
    }

    public void glowPlayerToken(){
        Effect glow = new Glow(1.0);
        playerText.setFill(Color.WHITE);
        playerText.setEffect(glow);
        playerText.setUnderline(true);
        playerText.setOpacity(1);
        playerPicture.setEffect(glow);
        glow = new Glow(0.8);
        playerToken.glowToken();
    }

    public void dimPlayerToken(){
        Effect glow = new Glow(0);
        playerText.setFill(Color.BLACK);
        playerText.setEffect(glow);
        playerText.setUnderline(false);
        playerText.setOpacity(1);
        playerPicture.setEffect(glow);
        playerToken.dimToken();
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

    @Override
    public String toString() {
        return "Player{" +
                "playerToken=" + playerToken +
                ", playerPicture=" + playerPicture +
                ", playerText=" + playerText +
                ", playerXLocation=" + playerXLocation +
                ", playerYLocation=" + playerYLocation +
                ", playerGameStarted=" + playerGameStarted +
                '}';
    }
}
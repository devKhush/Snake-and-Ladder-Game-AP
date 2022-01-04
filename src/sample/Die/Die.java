package sample.Die;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

import java.util.Random;


public class Die {
    private Random random = new Random();
    private int numberOfFaces = 6;
    private int faceValue;
    private ImageView rollingDie;
    private ImageView diceFaceImage;
    private ImageView diceImage1;
    private ImageView diceImage2;
    private ImageView diceImage3;
    private ImageView diceImage4;
    private ImageView diceImage5;
    private ImageView diceImage6;
    private DieFaceChanger dieFaceChanger;

    public Die(int numberOfFaces,ImageView diceFaceImage, ImageView diceImage1, ImageView diceImage2, ImageView diceImage3, ImageView diceImage4, ImageView diceImage5, ImageView diceImage6, ImageView rollingDie) {
        this.numberOfFaces = numberOfFaces;
        this.numberOfFaces = 6;
        this.diceFaceImage = diceFaceImage;
        this.diceImage1 = diceImage1;
        this.diceImage2 = diceImage2;
        this.diceImage3 = diceImage3;
        this.diceImage4 = diceImage4;
        this.diceImage5 = diceImage5;
        this.diceImage6 = diceImage6;
        this.rollingDie = rollingDie;
    }

    public void roll(){
        this.faceValue = random.nextInt(numberOfFaces) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public ImageView getRollingDie() {
        return rollingDie;
    }

    public ImageView getDiceFaceImage() {
        return diceFaceImage;
    }

    public ImageView getDiceImage1() {
        return diceImage1;
    }

    public ImageView getDiceImage2() {
        return diceImage2;
    }

    public ImageView getDiceImage3() {
        return diceImage3;
    }

    public ImageView getDiceImage4() {
        return diceImage4;
    }

    public ImageView getDiceImage5() {
        return diceImage5;
    }

    public ImageView getDiceImage6() {
        return diceImage6;
    }

    public void setDiceFaceImage(int faceValue){
        dieFaceChanger = new DieFaceChanger(this);
        Platform.runLater(dieFaceChanger);
    }
}
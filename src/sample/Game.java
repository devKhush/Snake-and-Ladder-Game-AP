package sample;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Game {

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
    ImageView no_image;

    @FXML
    ImageView playe2_pic;

    @FXML
    ImageView playe1_pic;

    @FXML
    Button roll_button;

    @FXML
    Text p1;

    @FXML
    Text p2;

    int count=0;

    public void btnROLLclicked(ActionEvent event) throws IOException
    {
        p1.setText(Controller.getPlayerNames()[0]);
        p1.setOpacity(1);
        p2.setText(Controller.getPlayerNames()[1]);
        p2.setOpacity(1);
        count++;
        if(count%2==0)
        {
            p1.setFill(Color.WHITE);
            Effect glow = new Glow(1.0);
            p1.setEffect(glow);
            p1.setUnderline(true);
            glow = new Glow(0.7);
            playe1_pic.setEffect(glow);
            glow = new Glow(0);
            p2.setFill(Color.BLACK);
            p2.setEffect(glow);
            p2.setUnderline(false);
            playe2_pic.setEffect(glow);
        }
        else
        {
            p2.setFill(Color.WHITE);
            Effect glow = new Glow(1.0);
            p2.setUnderline(true);
            p2.setEffect(glow);
            glow = new Glow(0.7);
            playe2_pic.setEffect(glow);
            glow = new Glow(0);
            p1.setEffect(glow);
            p1.setUnderline(false);
            p1.setFill(Color.BLACK);
            playe1_pic.setEffect(glow);
        }

        Random rand = new Random();
        int rand_int1 = rand.nextInt(6);
        if(rand_int1==0)
        {
            Image dice_1 =dice_image1.getImage();
            no_image.setImage(dice_1);
        }
        else if(rand_int1==1)
        {
            Image dice_2 =dice_image2.getImage();
            no_image.setImage(dice_2);
        }
        else if(rand_int1==2)
        {
            Image dice_3 =dice_image3.getImage();
            no_image.setImage(dice_3);
        }
        else if(rand_int1==3)
        {
            Image dice_4 =dice_image4.getImage();
            no_image.setImage(dice_4);
        }
        else if(rand_int1==4)
        {
            Image dice_5 =dice_image5.getImage();
            no_image.setImage(dice_5);
        }
        else if(rand_int1==5)
        {
            Image dice_6 =dice_image6.getImage();
            no_image.setImage(dice_6);
        }
    }

    public void setButtonSkin(){
        Glow glow = new Glow();
        glow.setLevel(0.8);
        roll_button.setEffect(glow);
    }

    public void removeButtonSkin() {
        Glow glow = new Glow();
        glow.setLevel(0);
        roll_button.setEffect(glow);
    }

    @FXML
    public void initialize()
    {
        String name_1=Controller.getPlayerNames()[0];
        String name_2=Controller.getPlayerNames()[1];
        p1.setText(name_1);
        p1.setOpacity(1);
        p2.setText(name_2);
        p2.setOpacity(1);
        p1.setFill(Color.WHITE);
        Effect glow = new Glow(1.0);
        p1.setEffect(glow);
        p1.setUnderline(true);
        glow = new Glow(0.7);
        playe1_pic.setEffect(glow);
        glow = new Glow(0);
        p2.setFill(Color.BLACK);
        p2.setEffect(glow);
        p2.setUnderline(false);
        playe2_pic.setEffect(glow);
    }

}
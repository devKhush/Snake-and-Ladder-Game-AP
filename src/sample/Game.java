package sample;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Game
{
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
    Button roll_button;

    public void btnROLLclicked(ActionEvent event) throws IOException
    {
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

}
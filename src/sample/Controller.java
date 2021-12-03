package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller
{

    @FXML
    private ImageView image;

    @FXML
    private TextField tfTitle1;

    @FXML
    private TextField tfTitle2;

    @FXML
    void btnOKclicked(ActionEvent event) throws IOException
    {
        Stage mainWindow = (Stage) tfTitle1.getScene().getWindow();
        String title1 = tfTitle1.getText();
        String title2 = tfTitle2.getText();
        if (title1.equals(""))
            title1 = "Player1";
        if (title2.equals(""))
            title2 = "Player2";
        mainWindow.setTitle(title1+" vs "+title2);
        mainWindow.close();

        Stage game = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        game.setTitle(title1+" vs "+title2);
        game.setScene(new Scene(root));
        game.show();
        String t=game.getTitle();
    }


}



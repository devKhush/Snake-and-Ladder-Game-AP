package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Image image = new Image(getClass().getResource("assets/snake.png").toExternalForm());
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Snakes & Ladders");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
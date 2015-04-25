package sample;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        //instantiate Player class
        Player player = new Player("file:///E:/ProgrammingVideos/JohnLegend-Success.mp4");
        //add the player to the scene
        Scene scene = new Scene(player, 720, 480, Color.BLACK);
        //adding the scene to the stage
        primaryStage.setScene(scene);
        //show the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

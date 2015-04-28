package sample;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        //add the menu items
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        //add the items to each other
        file.getItems().add(open);
        menu.getMenus().add(file);

        //instantiate Player class
        Player player = new Player("file:///E:/ProgrammingVideos/JohnLegend-Success.mp4");
        //add the menu to the player
        player.setTop(menu);
        //add the player to the scene
        Scene scene = new Scene(player, 720, 535, Color.BLACK);
        //adding the scene to the stage
        primaryStage.setScene(scene);
        //show the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


public class Main extends Application {

    Player player; //instantiate Player class
    FileChooser fileChooser; //add a file chooser and instantiate it
    public void start(final Stage primaryStage){

        //add the menu items
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        //add the items to each other
        file.getItems().add(open);
        menu.getMenus().add(file);

        fileChooser = new FileChooser();

        //set the action for the open button
        open.setOnAction(new EventHandler<ActionEvent> (){
            public void handle(ActionEvent event){
                //pause the player first
                player.player.pause();
                //create a new file
                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null){
                    try{
                        //get the file in the right format
                        player = new Player(file.toURI().toURL().toExternalForm());
                        //create a new scene
                        Scene scene = new Scene(player, 720, 535, Color.BLACK);
                        //add the scene to the primary stage
                        primaryStage.setScene(scene);
                    }catch (MalformedURLException e1){
                        e1.printStackTrace();
                    }
                }
            }
        });

        player = new Player("file:///E:/ProgrammingVideos/JohnLegend-Success.mp4");
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

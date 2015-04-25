package sample;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * Created by Khwilo on 4/25/2015.
 */
public class Player extends BorderPane {

    //to create the media the below items are necessary
    Media media;
    MediaPlayer player;
    MediaView view;

    //creating the pane for the player
    Pane pane;

    //the default constructor
    public Player(String file){
        media = new Media(file);
        player = new MediaPlayer(media);
        view = new MediaView(player);

        pane = new Pane();

        //add the view to the pane
        pane.getChildren().add(view);

        //the media pane is present but we need to add it the BorderPane which is our player class

        setCenter(pane); //this adds the pane to the center of the player

        //finally make the video play
        player.play();
    }
}

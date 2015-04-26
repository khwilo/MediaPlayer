package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

/**
 * Created by Khwilo on 4/26/2015.
 */
public class MediaBar extends HBox{

    //methods for the MediaBar
    Slider time = new Slider();
    Slider vol = new Slider();

    Button playButton = new Button("||");

    //adding the labels for the controls
    Label volume = new Label("Volume: ");

    //adding the media player for this class
    MediaPlayer player;

    //the default constructor
    public MediaBar(MediaPlayer play){
        player = play;

        //set the alignment of the horizontal box
        setAlignment(Pos.CENTER);
        //add some padding
        setPadding(new Insets(5,10,5,10)); //the order is top, right, bottom then left

        //the volume slider
        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100); //the default volume value

        //the time slider
        HBox.setHgrow(time, Priority.ALWAYS);

        //setting the width of the play button
        playButton.setPrefWidth(30);

        //adding the attributes to the media player
        //this is done in order of appearance in the media
        getChildren().add(playButton);
        getChildren().add(time);
        getChildren().add(volume);
        getChildren().add(vol);
    }
}

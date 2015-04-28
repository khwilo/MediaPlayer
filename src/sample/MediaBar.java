package sample;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        //set the action for the button
        playButton.setOnAction(new EventHandler<ActionEvent> (){
            public void handle(ActionEvent e){
                //check the status of the media player
                MediaPlayer.Status status = player.getStatus();

                if(status == MediaPlayer.Status.PLAYING){
                    if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                        //play the file from the beginning
                        player.seek(player.getStartTime()); //seek the time
                        player.play();
                    }
                    else{ //pause if not at the end of the file
                        player.pause();
                        playButton.setText(">");
                    }
                }

                if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.HALTED || status == MediaPlayer.Status.STOPPED){
                    //first play the file
                    player.play();
                    //set the text of the button
                    playButton.setText("||");
                }
            }
        });

        //update the time slider
        player.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                updateValues();
            }
        });

        time.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable){
                //check if the time slider is pressed
                if(time.isPressed()){
                    player.seek(player.getMedia().getDuration().multiply(time.getValue() / 100));
                }
            }
        });
    }

    protected void updateValues(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis() * 100);
            }
        });
    }
}

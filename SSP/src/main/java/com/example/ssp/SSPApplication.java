package com.example.ssp;
import javafx.scene.media.Media;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class SSPApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        music();
        FXMLLoader fxmlLoader = new FXMLLoader(SSPApplication.class.getResource("SSP.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Hello! Welcome to our rock-paper-scissors game");
        stage.setScene(scene);
        stage.show();
    }

    //add music
    MediaPlayer mediaPlayer;
    public void music(){
        String s = "SSP/src/main/resources/com/example/ssp/music/8d82b5_Star_Wars_Main_Theme_Song.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer =new MediaPlayer(h);
        mediaPlayer.play();
    }


    public static void main(String[] args) {
        launch();
    }
}


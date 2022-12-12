package com.example.ssp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.util.Objects;
import java.util.Random;

public class SSPController {

    @FXML
    private Text highscore;
    @FXML
    private Text rockpaperscissors;
    @FXML
    private Text score;
    @FXML
    private Button stop;
    @FXML
    private Button tryAgain;
    @FXML
    public Button play;
    @FXML
    public Button exit;
    @FXML
    private ImageView imgviewmiddle;
    @FXML
    private ImageView imgviewright;
    @FXML
    private ImageView imgviewleft;
    @FXML
    private ProgressBar progBar;
    @FXML
    private ProgressIndicator progIndicator;
    @FXML
    private Button fountain;
    private int choice;

    //to check if button has been pressed
    boolean check = false;
    //to check if fountain has been pressed
    boolean checkFountain = false;

    //random choice of AI, Ai can not choose fountain
    Random random = new Random();
    int choice2;

    private String player = "player";
    private String ai = "AI";
    private String winner = "";

    //4 images Path!!!
    private Image image = new Image("C:\\3AHITN\\SEW\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\image_processing20210612-767-1ib2eof.png");
    private Image image1 = new Image("C:\\3AHITN\\SEW\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\64750.jpg");
    private Image image2 = new Image("C:\\3AHITN\\SEW\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\361-3618497_scissors-clipart-19-scissors-image-graphic-huge-freebie.png");
    private Image image3 = new Image("C:\\3AHITN\\SEW\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\720Brunnen.png");

    //choose stone,scissors,paper or fountain
    @FXML
    public void onScissorsClick() {
        if (!check) {
            choice = 1;
            move();
        }
    }

    @FXML
    public void onStoneClick() {
        if (!check) {
            choice = 2;
            imgviewleft.setImage(image);
            move();
        }
    }

    @FXML
    public void onPaperClick() throws InterruptedException {
        if (!check) {
            choice = 3;
            imgviewleft.setImage(image1);
            move();
        }
    }

    //use max 1 time per try
    @FXML
    public void onFountainClick() {
        if (!check && !checkFountain) {
            checkFountain = true;
            choice = 4;
            imgviewleft.setImage(image3);
            move();
        }
    }

    //set imageview right
    public void setImgviewright() {
        choice2 = random.nextInt(3) + 1;
        if (choice2 == 1) {
            imgviewright.setImage(image2);
        } else if (choice2 == 2) {
            imgviewright.setImage(image);
        }
        winner();
        rockpaperscissors.setVisible(true);
    }

    //make imageview middle invisible
    public void move() {
        imgviewmiddle.setVisible(false);
        check = true;
        setImgviewright();
    }

    //check winner, keep score if it's a draw
    public void winner() {
        if (choice == 1 && choice2 == 3) {
            winner = player;
        } else if (choice == 1 && choice2 == 2) {
            winner = ai;
        } else if (choice == 2 && choice2 == 1) {
            winner = player;
        } else if (choice == 2 && choice2 == 3) {
            winner = ai;
        } else if (choice == 3 && choice2 == 1) {
            winner = ai;
        } else if (choice == 3 && choice2 == 2) {
            winner = player;
        } else if (choice == 4 && choice2 == 1) {
            winner = player;
        } else if (choice == 4 && choice2 == 2) {
            winner = player;
        } else if (choice == 4 && choice2 == 3) {
            winner = ai;
        } else if (choice == choice2) {
            winner = "Draw";
        }

        String d = score.getText();
        String e = d.substring(15);
        int f = Integer.parseInt(e);
        if (Objects.equals(winner, player)) {
            rockpaperscissors.setText("You are the Winner");
            String b = highscore.getText();
            String c = b.substring(12);
            int a = Integer.parseInt(c);
            f++;
            progBar.setProgress(progBar.getProgress()+0.1);
            progIndicator.setProgress(progIndicator.getProgress()+0.1);
            score.setText("Current score: " + f);
            if (f > a) {
                a++;
                highscore.setText("High Score: " + a);
                if (f==10){
                    finish();
                }
            }
            play.setText("Next Round");
        } else if (Objects.equals(winner, ai)) {
            rockpaperscissors.setText("You are the Loser");
            play.setText("Play Again");
            progBar.setProgress(0);
            progIndicator.setProgress(0);
        } else if (Objects.equals(winner, "Draw")) {
            rockpaperscissors.setText("It's a draw");
            play.setText("Next Round");
        }

        if (f!=10){
            play.setVisible(true);
            exit.setVisible(true);
        }
    }

    //play again/next round
    @FXML
    public void onPlayClick() {
        imgviewmiddle.setVisible(true);
        check = false;
        play.setVisible(false);
        exit.setVisible(false);
        imgviewright.setImage(image1);
        imgviewleft.setImage(image2);
        rockpaperscissors.setText("Rock Paper Scissors");
        if (Objects.equals(play.getText(), "Play Again")) {
            score.setText("Current Score: 0");
            checkFountain = false;
        }
    }

    //exit
    @FXML
    public void onExitClick() {
        System.exit(0);
    }

    //if you won 10 times in a row
    public void finish(){
        check=true;
        score.setVisible(false);
        highscore.setVisible(false);
        rockpaperscissors.setText("You are the best of all time (GOAT)!!!");
        fountain.setVisible(false);
        play.setVisible(false);
        exit.setVisible(false);
        imgviewleft.setVisible(false);
        imgviewright.setVisible(false);
        tryAgain.setVisible(true);
        stop.setVisible(true);
    }

    //if you finished the game and want to play again
    public void onTryAgainClick(){
        onPlayClick();
        checkFountain=false;
        imgviewleft.setVisible(true);
        imgviewright.setVisible(true);
        tryAgain.setVisible(false);
        stop.setVisible(false);
        fountain.setVisible(true);
        score.setVisible(true);
        score.setText("Current Score: 0");
        highscore.setVisible(true);
        progBar.setProgress(0);
    }
}


package com.example.ssp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.util.Objects;
import java.util.Random;

public class SSPController {

    @FXML
    private Button paper;

    @FXML
    private Button scissors;

    @FXML
    private Button stone;

    @FXML
    private Text highscore;
    @FXML
    private Text rockpaperscissors;

    @FXML
    private ImageView imgviewmiddle;
    @FXML
    private ImageView imgviewright;
    @FXML
    private ImageView imgviewleft;
    private int choice;

    boolean check=false;

    Random random = new Random();
    int choice2 = random.nextInt(3)+1;

    private String player = "player";
    private String ai = "AI";
    private String winner = "";

    @FXML
    public void onScissorsClick() {
        if (!check){
            choice = 1;
            move();
            setImgviewright();
        }
    }

    @FXML
    public void onStoneClick() {
        if (!check){
            choice = 2;
            move();
            Image image = new Image("H:\\ITP2\\3AHITN\\IntelliJ\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\image_processing20210612-767-1ib2eof.png");
            imgviewleft.setImage(image);
            setImgviewright();
        }
    }

    @FXML
    public void onPaperClick() throws InterruptedException {
        if (!check){
            choice = 3;
            move();
            Image image1=new Image("H:\\ITP2\\3AHITN\\IntelliJ\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\64750.jpg");
            imgviewleft.setImage(image1);
            setImgviewright();
        }
    }
    public void setImgviewright(){
        if (choice2==1){
            Image image2 =new Image("H:\\ITP2\\3AHITN\\IntelliJ\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\361-3618497_scissors-clipart-19-scissors-image-graphic-huge-freebie.png");
            imgviewright.setImage(image2);
        } else if (choice2==2) {
            Image image3 =new Image("H:\\ITP2\\3AHITN\\IntelliJ\\SSP_adilic_fgaertne_astokani\\SSP\\src\\main\\resources\\images\\image_processing20210612-767-1ib2eof.png");
            imgviewright.setImage(image3);
        }
        winner();
        rockpaperscissors.setVisible(true);
    }

    public void move() {
        rockpaperscissors.setVisible(false);
        imgviewmiddle.setVisible(false);
        check=true;
    }

    public void winner(){
        if (choice == 1 && choice2 == 3 ){
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
        }

        if (Objects.equals(winner, player)){
            rockpaperscissors.setText("You are the Winner");
            String b=highscore.getText().replaceAll("a-zA-Z"," ");
            int a= Integer.parseInt(b);
            a++;
            highscore.setText("Highscore: " + a);
        } else if (Objects.equals(winner, ai)){
            rockpaperscissors.setText("You are the Loser");
        } else {
            rockpaperscissors.setText("It's a draw");
        }
    }
}


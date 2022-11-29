package com.example.ssp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class SSPController {

    @FXML
    private Button paper;

    @FXML
    private Button scissor;

    @FXML
    private Button stone;

    private int choice;

    Random random = new Random();
    int choice2 = random.nextInt();

    private String player = "player";
    private String ai = "AI";
    private String winner = "";


    @FXML
    public void OnScissorsClick() {
        choice = 1;
    }

    @FXML
    public void OnStoneClick() {
        choice = 2;
    }

    @FXML
    public void OnPaperClick() {
        choice = 3;
    }
    
    @FXML
    public void Winner(){
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
    }
    



}


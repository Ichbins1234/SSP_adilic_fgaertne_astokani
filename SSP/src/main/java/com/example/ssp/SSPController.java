package com.example.ssp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SSPController {

    @FXML
    private Button paper;

    @FXML
    private Button scissor;

    @FXML
    private Button stone;

    private int choice;

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



}
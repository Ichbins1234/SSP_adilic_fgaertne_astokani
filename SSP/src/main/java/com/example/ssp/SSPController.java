package com.example.ssp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SSPController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
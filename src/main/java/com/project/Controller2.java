package com.project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller2 implements Initializable{

    @FXML
    public Button returnb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        returnb.setOnAction(event -> {
            UtilsViews.setViewAnimating("View0");
        });
    }
    

}
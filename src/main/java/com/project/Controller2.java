package com.project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import org.bouncycastle.openpgp.examples.KeyBasedFileProcessor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Controller2 implements Initializable{

    @FXML
    public Button returnb;

    @FXML
    public Button desencript;

    @FXML
    public TextField arxiu;

    @FXML
    public TextField cprivada;

    @FXML 
    public TextField contrasenya;

    @FXML
    public TextField desti;

    File arxiuDesEncriptar;
    File clauPrivada;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Retornar al menu
        returnb.setOnAction(event -> {
            UtilsViews.setViewAnimating("View0");
            Main.result = false;
        });

        FileChooser fc = new FileChooser();

        //Arxiu a desencriptar
        arxiu.setOnMouseClicked(e -> {
            
            File selFile = fc.showOpenDialog(null);

            if (selFile != null) {
                arxiu.setText(selFile.getName());
                arxiuDesEncriptar = selFile;
            } else {
                arxiu.setText("");
                arxiuDesEncriptar = null;
            }
            desti.requestFocus();
        });

        //ClauPrivada
        cprivada.setOnMouseClicked(e ->{

            File selFile = fc.showOpenDialog(null);

            if (selFile != null) {
                cprivada.setText(selFile.getName());
                clauPrivada = selFile;
            } else {
                cprivada.setText("");
                clauPrivada = null;
            }
            desti.requestFocus();
        });

        //Boton desencriptar
        desencript.setOnMouseClicked(e -> {
            try {
                if (arxiuDesEncriptar != null && clauPrivada != null) {
                    EncryptorUtils.decryptFile(arxiuDesEncriptar.getAbsolutePath().toString(), clauPrivada.getAbsolutePath().toString(), contrasenya.getText().toCharArray(), System.getProperty("user.dir")+"/data/"+desti.getText());
                    UtilsViews.addView(getClass(), "ViewR", "/assets/menu4.fxml");
                    UtilsViews.setView("ViewR");
                }
            } catch (Exception error) {
                // TODO: handle exception
            }
            
        });
        
    }
    
    

}
package com.project;

import java.net.URL;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.*;

public class Controller1 implements Initializable{

    @FXML
    public Button returnb;

    @FXML
    public Button encript;

    @FXML
    public TextField claup;

    @FXML
    public TextField arxiu;

    @FXML
    public TextField desti;


    public File clauPublica;
    public File arxiuAEncriptar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Boton volver atras
        returnb.setOnAction(event -> {
            UtilsViews.setViewAnimating("View0");
            Main.result = false;
        });
        
        //Clau publica
        FileChooser fc = new FileChooser();
        claup.setOnMouseClicked(e -> {
            File selCFile = fc.showOpenDialog(null);
            
            if (selCFile != null) {
                claup.setText(selCFile.getName());
                clauPublica = selCFile;
            }
            desti.requestFocus();
        });

        //Arxiu
        arxiu.setOnMouseClicked(e -> {
            File selFile = fc.showOpenDialog(null);

            if (selFile != null) {
                arxiu.setText(selFile.getName());
                arxiuAEncriptar = selFile;
            }

            desti.requestFocus();
        });
        
        //Encriptar
        encript.setOnMouseClicked(e -> {
            
            if (clauPublica != null && arxiuAEncriptar != null) {
                String outputPath = System.getProperty("user.dir")+"/data/"+desti.getText();
                System.out.println(outputPath);
                try {
                    EncryptorUtils.encryptFile(outputPath, arxiuAEncriptar.getAbsolutePath().toString(), clauPublica.getAbsolutePath().toString(), true, true);
                    UtilsViews.addView(getClass(), "ViewR", "/assets/menu4.fxml");
                    UtilsViews.setView("ViewR");
                    
                } catch (IOException | PGPException e1) {
                    e1.printStackTrace();
                } catch (NoSuchProviderException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }
    
    

}

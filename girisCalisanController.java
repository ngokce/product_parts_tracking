package com.example.uruntakip1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class girisCalisanController extends depoBilgiController{
    @FXML
    public TextField calisanid;
    @FXML
    public PasswordField calisansifre;
    @FXML
    public Button urunButon,parcaButon,depoButon;


    public void urunSayfa() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("urunBilgi.fxml"));
        Parent root = loader.load();
        Initializable controller = loader.getController();
        Stage stage = (Stage) urunButon.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void parcaSayfa() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("parcaBilgi.fxml"));
        Parent root = loader.load();
        parcaBilgiController controller = loader.getController();
        Stage stage = (Stage) parcaButon.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void depoSayfa() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("depoBilgi.fxml"));
        Parent root = loader.load();
        depoBilgiController controller = loader.getController();
        Stage stage = (Stage) depoButon.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

package com.example.uruntakip1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class parcaGirController {
    @FXML
    public TextField parcaKod,parcaAd,urunKod,fiyat;
    @FXML
    public Button geriUrun,parcaEkleButon;

    public void girisCalisan() throws IOException {    // geri tuşu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("parcaBilgi.fxml"));
        Parent root = loader.load();
        parcaBilgiController controller = loader.getController();
        Stage stage = (Stage) geriUrun.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void parcaEkle(ActionEvent event) throws IOException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        PreparedStatement statement = null;


        connectDB = connectNow.getConnection();

        try {
            String ekleme = "INSERT INTO parcalar(parcaKod,parcaAd,urunKod,fiyat)" +
                    "Values (?,?,?,?)";

            statement = connectDB.prepareStatement(ekleme);
            statement.setString(1, parcaAd.getText());
            statement.setString(2, parcaKod.getText());
            statement.setString(3, urunKod.getText());
            statement.setString(4, fiyat.getText());


            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }}

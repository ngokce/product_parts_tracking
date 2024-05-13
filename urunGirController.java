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

public class urunGirController {
    @FXML
    public TextField urunKod,urunAd,urunMiktar;
    @FXML
    public Button geriUrun,urunEkleButon;

    public void girisCalisan() throws IOException {    // geri tuşu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("urunBilgi.fxml"));
        Parent root = loader.load();
        Initializable controller = loader.getController();
        Stage stage = (Stage) geriUrun.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void urunEkle(ActionEvent event) throws IOException, SQLException
    {


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        PreparedStatement statement = null;




        connectDB = connectNow.getConnection();

        try{
            String urunEkle ="INSERT INTO urunler(urunKod,urunAd,urunMiktar)"+
                    " Values (?,?,?)";

            statement = connectDB.prepareStatement(urunEkle);
            statement.setString(1,urunKod.getText());
            statement.setString(2,urunAd.getText());
            statement.setString(3,urunMiktar.getText());

            statement.executeUpdate();

            }

        catch (Exception e){
        }



    }



}

package com.example.uruntakip1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class parcaBilgiController {
    @FXML
    public TableView<Parca> parcaTable;
    @FXML
    public TableColumn<Parca,Integer> parcaKodu;
    @FXML
    public TableColumn<Parca,String> parcaAdi;
    @FXML
    public TableColumn<Parca,Integer> urunKodu;
    @FXML
    public TableColumn<Parca,Integer> fiyat;
    @FXML
    public Button geriUrun,parcaEkleButon;


    public void girisCalisan() throws IOException {     //geri tuşu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("girisCalisan.fxml"));
        Parent root = loader.load();
        girisCalisanController controller = loader.getController();
        Stage stage = (Stage) geriUrun.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void parcaEkleSayfasi() throws IOException {    // parça gir sayfası.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("parcaGir.fxml"));
        Parent root = loader.load();
        parcaGirController controller = loader.getController();
        Stage stage = (Stage) parcaEkleButon.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public static ObservableList<Parca> parcaGir() throws SQLException {   // parça gir.
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ObservableList<Parca> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connectDB.prepareStatement("SELECT parcaKod,parcaAd,urunKod,miktar from parcalar");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Parca(rs.getInt("parcaKod"), rs.getString("parcaAd"),
                        rs.getInt("urunKod"), rs.getInt("urunMiktar") ));
            }

        }
        catch (Exception e){
        }
        return list;
    }
    ObservableList<Parca> listParca;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        parcaKodu.setCellValueFactory(new PropertyValueFactory<Parca,Integer>("parcaKodu"));
        parcaAdi.setCellValueFactory(new PropertyValueFactory<Parca,String>("parcaAdi"));
        urunKodu.setCellValueFactory(new PropertyValueFactory<Parca,Integer>("urunKodu"));
        fiyat.setCellValueFactory(new PropertyValueFactory<Parca,Integer>("fiyat"));
        try {
            listParca=parcaGir();
            parcaTable.setItems(listParca);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

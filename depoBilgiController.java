package com.example.uruntakip1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class depoBilgiController implements Initializable {
    @FXML
    public TableView<Depo> depoTable;
    @FXML
    public TableColumn<Depo,Integer> depoKodu;
    @FXML
    public TableColumn<Depo,String> depoAdi;
    @FXML
    public TableColumn<Depo,String> depoSehir;
    @FXML
    public TableColumn<Depo,Integer> depoKapasite;
    @FXML
    public Button geriUrun;


    public void girisCalisan() throws IOException {     //geri tuşu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("girisCalisan.fxml"));
        Parent root = loader.load();
        girisCalisanController controller = loader.getController();
        Stage stage = (Stage) geriUrun.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static ObservableList<Depo> veri_cek() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ObservableList<Depo> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connectDB.prepareStatement("select * from Depo");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Depo(rs.getInt("depoKod"), rs.getString("depoAd"), (rs.getString("sehir")),rs.getInt("kapasite")));
            }

        }
        catch (Exception e){

        }


        return list;


    }

    ObservableList<Depo> listM;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(this.depoTable!=null){
            depoKodu.setCellValueFactory(new PropertyValueFactory<Depo,Integer>("depoKod"));
            depoAdi.setCellValueFactory(new PropertyValueFactory<Depo,String>("DepoAd"));
            depoSehir.setCellValueFactory(new PropertyValueFactory<Depo,String>("sehir"));
            depoKapasite.setCellValueFactory(new PropertyValueFactory<Depo,Integer>("kapasite"));

            try {
                listM = veri_cek();
                depoTable.setItems(listM);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

}

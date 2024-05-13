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

public class urunBilgiController implements Initializable {
    @FXML
    public TableView<Urun> urunTable;
    @FXML
    public TableColumn<Urun,Integer> urunKodu;
    @FXML
    public TableColumn<Urun,String> urunAdi;
    @FXML
    public TableColumn<Urun,Integer> urunMiktari;
    @FXML
    public Button geriUrun,urunEkleButon;

    public void girisCalisan() throws IOException {    // geri tuşu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("girisCalisan.fxml"));
        Parent root = loader.load();
        girisCalisanController controller = loader.getController();
        Stage stage = (Stage) geriUrun.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // ürün gir ekrarnına git.
    public void urunEkleSayfasi() throws IOException {    // ürün gir sayfası.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("urunGir.fxml"));
        Parent root = loader.load();
        urunGirController controller = loader.getController();
        Stage stage = (Stage) urunEkleButon.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


        public static ObservableList <Urun> veri_cek() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        ObservableList<Urun> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connectDB.prepareStatement("SELECT * from urunler");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Urun(rs.getInt("urunKod"), rs.getString("urunAd"),
                        rs.getInt("urunMiktar") ));            }

        }
        catch (Exception e){

        }


        return list;


    }


    ObservableList<Urun> listUrun;

    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        urunKodu.setCellValueFactory(new PropertyValueFactory<Urun,Integer>("urunKodu"));
        urunAdi.setCellValueFactory(new PropertyValueFactory<Urun,String>("urunAdi"));
        urunMiktari.setCellValueFactory(new PropertyValueFactory<Urun,Integer>("urunMiktari"));
        try {
            listUrun=veri_cek();
            urunTable.setItems(listUrun);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

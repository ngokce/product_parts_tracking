module com.example.uruntakip1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.uruntakip1 to javafx.fxml;
    exports com.example.uruntakip1;
}
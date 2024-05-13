package com.example.uruntakip1;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaselink;

    public Connection getConnection(){
        String databaseName = "BordroDB";
        String databaseUser = "root";
        String databasePassword = "12341234";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseUser,databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  databaselink;

    }


}

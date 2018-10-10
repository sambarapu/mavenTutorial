package com.java.basics.database;

import java.sql.DriverManager;
import java.sql.Connection;

public class DbConnection {

    /**
     *
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/homeDB", "root", "home");
            return  connection;
        } catch (Exception exception){
            throw exception;
        }
    }

}

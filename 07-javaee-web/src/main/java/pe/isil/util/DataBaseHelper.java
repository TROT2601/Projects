package pe.isil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {

    private static final String URL = "jdbc:mysql://mysql02.c4utrkzk5zgf.us-west-1.rds.amazonaws.com:3306/isil_db";
    private static final String USER = "isil";
    private static final String PASSWORD = "isil";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}



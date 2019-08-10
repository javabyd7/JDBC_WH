package pl.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {


    private static Connection connection;
    private final static String ADRESS = "jdbc:mysql://localhost";
    private final static String DATABASE = "employee_db";
    private final static String USER = "admin";
    private final static String PASSWORD = "admin";
    private final static String PORT = "8889";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String PARAMS = "serverTimezone=UTC";

    private static String getFormatedUrl(){
        return ADRESS+":"+PORT+"/"+DATABASE+"?"+PARAMS;
    }

    private static void loadDriver(){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void loadConnection(){
        try {
            connection = DriverManager.getConnection(getFormatedUrl(),USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(connection == null){
            loadDriver();
            loadConnection();
        }

        return connection;
    }

    private DbConnector() {

    }
}

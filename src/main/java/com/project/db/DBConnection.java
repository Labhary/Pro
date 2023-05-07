package com.project.db;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static String dbUrl;
    private static String login;
    private static String password;
    private static String driver;
    private static Connection connection=null;

    private DBConnection() throws SQLException, ClassNotFoundException, IOException {
        Properties dbProperties = DbPropertiesLoader.loadPoperties("conf.properties");
        dbUrl = dbProperties.getProperty("db.url");
        login = dbProperties.getProperty("db.login");
        password = dbProperties.getProperty("db.password");
        driver = dbProperties.getProperty("db.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(dbUrl, login, password);
    }
    public static Connection getInstance() throws SQLException, ClassNotFoundException, IOException {
        if (connection == null) {
            new DBConnection();
        }

        return connection;
    }
}


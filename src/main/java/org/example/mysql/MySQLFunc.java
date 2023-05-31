package org.example.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFunc {
    private final String HOST;
    private final String DB;
    private final String USER;
    private final String PASS;
    private final String PORT;
    private Connection conn;
    public MySQLFunc(String host, String db, String user, String pass, String port) {
        this.HOST = host;
        this.DB = db;
        this.USER = user;
        this.PASS = pass;
        this.PORT = port;
    }

    public Connection open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?useSSL=false", USER, PASS);
            return conn;
        } catch (SQLException e) {
            System.out.println("Could not connect to MySQL server, error code: " + e.getErrorCode());
        } catch (ClassNotFoundException e){
            System.out.println("JDBC driver was not found in this machine.");
        }
        return conn;
    }

    public boolean checkConnection() {
        return conn != null;
    }

    public void close(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println("Could not close mysql connection, error code: " + e.getErrorCode());
        }
    }
}

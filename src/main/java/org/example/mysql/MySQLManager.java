package org.example.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
    private boolean isDebugMode;
    private String HOST;
    private String DB;
    private String USER;
    private String PASS;
    private String PORT;
    private String connectionName;
    private boolean isConnected;
    private Statement statement;
    private Connection connection;
    MySQLFunc mySQLFunc;

    public MySQLManager(String connectionName) {
        loadConfig();
        HOST = "localhost";
        USER = "root";
        PASS = "mk871396";
        PORT = "3306";
        DB = "smscdatabase";
        this.connectionName = connectionName;
        createTables();
    }

    private void loadConfig() {
        // TODO ファイルから読み込む
    }

    private void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean Connect(String host, String db, String user, String pass, String port) {
        HOST = host;
        DB = db;
        USER = user;
        PASS = pass;
        mySQLFunc = new MySQLFunc(HOST, DB, USER, PASS, PORT);
        connection = mySQLFunc.open();
        if (connection == null) {
            System.out.println("failed to open MYSQL");
            return false;
        }
        try {
            statement = connection.createStatement();
            isConnected = true;
            System.out.println("[" + connectionName + "] " + "Connected to the database");
        } catch (SQLException e) {
            isConnected = false;
            System.out.println("[" + connectionName + "] " + "Could not connect to the database");
        }
        mySQLFunc.close(connection);
        return isConnected;
    }

    public boolean checkConnect() {
        return Connect(HOST, DB, USER, PASS, PORT);
    }

    public boolean execute(String query) {
        mySQLFunc = new MySQLFunc(HOST, DB, USER, PASS, PORT);
        connection = mySQLFunc.open();
        if (connection == null) {
            System.out.println("failed to open MYSQL");
            return false;
        }
        if (isDebugMode) {
            System.out.println("query: " + query);
        }
        boolean isSuccess = true;
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("[" + connectionName + "] Error executing statement: " + e.getErrorCode() + ":" + e.getLocalizedMessage());
            System.out.println(query);
            isSuccess = false;
        }
        close();
        return isSuccess;
    }

    public ResultSet query(String query) {
        mySQLFunc = new MySQLFunc(HOST, DB, USER, PASS, PORT);
        connection = mySQLFunc.open();
        ResultSet resultSet = null;
        if (connection == null) {
            System.out.println("failed to open MYSQL");
            return null;
        }
        if (isDebugMode) {
            System.out.println("query: " + query);
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("[" + connectionName + "] Error executing query: " + e.getErrorCode() + ":" + e.getLocalizedMessage());
            System.out.println(query);
        }
        return resultSet;
    }

    public void close() {
        try {
            statement.close();
            connection.close();
            mySQLFunc.close(connection);
        } catch (SQLException e) {
        }
    }

    public void createTables() {
        execute(
                "CREATE TABLE IF NOT EXISTS smsc_users(" +
                        "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                        "uuid VARCHAR(36) NOT NULL DEFAULT 'none'," +
                        "student_number VARCHAR(5) NOT NULL DEFAULT 0," +
                        "first_name VARCHAR(32) NOT NULL DEFAULT 'none'," +
                        "last_name VARCHAR(32) NOT NULL DEFAULT 'none'," +
                        "sex enum('male', 'female', 'no_answer')," +
                        "birth_date date NOT NULL DEFAULT '2000:01:01'," +
                        "query_date date NOT NULL DEFAULT '2000:01:01'," +
                        "update_date date NOT NULL DEFAULT '2000:01:01')");
    }
}
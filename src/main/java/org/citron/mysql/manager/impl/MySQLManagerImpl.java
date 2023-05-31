package org.citron.mysql.manager.impl;

import org.citron.mysql.manager.MySQLManager;
import org.citron.mysql.manager.model.MySQLConfigMdl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManagerImpl implements MySQLManager {
    private boolean isDebugMode;
    private MySQLConfigMdl mdl;
    private String connectionName;
    private boolean isConnected;
    private Statement statement;
    private Connection connection;
    MySQLFuncImpl mySQLFunc;

    public MySQLManagerImpl(String connectionName) {
        loadConfig();
        mdl.setHOST("localhost");
        mdl.setUSER("root");
        mdl.setPASS("mk871396");
        mdl.setDB("smscdatabase");
        mdl.setPORT("3306");
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
        mdl.setHOST(host);
        mdl.setUSER(user);
        mdl.setPASS(pass);
        mdl.setDB(db);
        mdl.setPORT(port);
        mySQLFunc = new MySQLFuncImpl(mdl.getHOST(), mdl.getDB(), mdl.getUSER(), mdl.getPASS(), mdl.getPORT());
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

    @Override
    public boolean checkConnect() {
        return Connect(mdl.getHOST(), mdl.getDB(), mdl.getUSER(), mdl.getPASS(), mdl.getPORT());
    }

    @Override
    public boolean execute(String query) {
        mySQLFunc = new MySQLFuncImpl(mdl.getHOST(), mdl.getDB(), mdl.getUSER(), mdl.getPASS(), mdl.getPORT());
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

    @Override
    public ResultSet query(String query) {
        mySQLFunc = new MySQLFuncImpl(mdl.getHOST(), mdl.getDB(), mdl.getUSER(), mdl.getPASS(), mdl.getPORT());
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

    @Override
    public void close() {
        try {
            statement.close();
            connection.close();
            mySQLFunc.close(connection);
        } catch (SQLException e) {
        }
    }

    private void createTables() {
        execute(
                "CREATE TABLE IF NOT EXISTS smscUsers(" +
                        "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                        "uuid VARCHAR(36) NOT NULL DEFAULT 'none'," +
                        "studentNumber INT NOT NULL DEFAULT 0," +
                        "firstName VARCHAR(32) NOT NULL DEFAULT 'none'," +
                        "lastName VARCHAR(32) NOT NULL DEFAULT 'none'," +
                        "sex enum('male', 'female', 'no_answer')," +
                        "birthDate date NOT NULL DEFAULT '2000:01:01'," +
                        "queryDate date NOT NULL DEFAULT '2000:01:01'," +
                        "updateDate date NOT NULL DEFAULT '2000:01:01')");
    }
}
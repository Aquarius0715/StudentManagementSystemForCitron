package org.citron.mysql.manager;

import java.sql.ResultSet;

public interface MySQLManager {
    boolean checkConnect();
    boolean execute(String query);
    ResultSet query(String query);
    void close();
}

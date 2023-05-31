package org.citron.mysql.manager;

import java.sql.Connection;

public interface MySQLFunc {
    Connection open();
    boolean checkConnection();
    void close(Connection connection);
}

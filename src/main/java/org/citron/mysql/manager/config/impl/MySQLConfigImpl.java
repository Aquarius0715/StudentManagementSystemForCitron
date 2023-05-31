package org.citron.mysql.manager.config.impl;

import org.citron.mysql.manager.config.MySQLConfig;
import org.yaml.snakeyaml.Yaml;

public class MySQLConfigImpl implements MySQLConfig {
    private String host;
    private String user;
    private String pass;
    private String port;
    private String db;

    public String getHost() {
        return host;
    }
    public String getUser() {
        return user;
    }
    public String getPass() {
        return pass;
    }
    public String getPort() {
        return port;
    }
    public String getDb() {
        return db;
    }

    @Override
    public MySQLConfigImpl loadConfig() {
        return new Yaml().load(MySQLConfigImpl.class.getResourceAsStream("src/main/java/org/example/mysql/config/config.yml"));
    }
}

package org.example.mysql;

import org.yaml.snakeyaml.Yaml;

public class MySQLConfig {
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

    public static MySQLConfig loadConfig() {
        return new Yaml().load(MySQLConfig.class.getResourceAsStream("src/main/java/org/example/mysql/config/config.yml"));
    }
}

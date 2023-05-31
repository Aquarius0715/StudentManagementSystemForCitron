package org.citron.mysql.manager.model;

public class MySQLConfigMdl {
    private String HOST;
    private String DB;
    private String USER;
    private String PASS;
    private String PORT;

    public String getDB() {
        return DB;
    }
    public String getHOST() {
        return HOST;
    }
    public String getPASS() {
        return PASS;
    }
    public String getPORT() {
        return PORT;
    }
    public String getUSER() {
        return USER;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }
}

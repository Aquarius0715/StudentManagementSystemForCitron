package org.citron.main;

import org.citron.mysql.manager.impl.MySQLManagerImpl;

public class Main {

    public static void main(String[] args) {
        MySQLManagerImpl sqlManager = new MySQLManagerImpl("test");
    }
}
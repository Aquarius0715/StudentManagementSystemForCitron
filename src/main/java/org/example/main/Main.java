package org.example.main;

import org.example.logging.Logger;
import org.example.mysql.MySQLManager;

public class Main {

    public static void main(String[] args) {
        MySQLManager sqlManager = new MySQLManager("test");
    }
}
package org.citron.mysql.manager.config;

import org.citron.mysql.manager.config.impl.MySQLConfigImpl;

public interface MySQLConfig {
    public MySQLConfigImpl loadConfig();
}

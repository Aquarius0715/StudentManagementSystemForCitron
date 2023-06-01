package org.citron.mysql.dao;

import org.citron.mysql.dto.SMSCUsersDTO;

import java.util.ArrayList;

public interface SMSCUsersDAO {
    ArrayList<SMSCUsersDTO> loadAllUsers();
    void storeSMSCUsers(ArrayList<SMSCUsersDTO> dto);
}

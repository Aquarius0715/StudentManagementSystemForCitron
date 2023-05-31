package org.citron.mysql.dao;

import org.citron.mysql.dto.smscUsersDTO;

import java.util.ArrayList;

public interface smscUsersDAO {
    ArrayList<smscUsersDTO> loadAllUsers();
    void storeSMSCUsers(ArrayList<smscUsersDTO> dto);
}

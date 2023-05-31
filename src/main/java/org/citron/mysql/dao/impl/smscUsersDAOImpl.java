package org.citron.mysql.dao.impl;

import org.citron.mysql.dao.smscUsersDAO;
import org.citron.mysql.dto.smscUsersDTO;
import org.citron.mysql.manager.impl.MySQLManagerImpl;
import org.citron.struct.Sex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class smscUsersDAOImpl implements smscUsersDAO {
    MySQLManagerImpl manager;

    public smscUsersDAOImpl() {
        manager = new MySQLManagerImpl("smscUsersDAO");
    }
    @Override
    public ArrayList<smscUsersDTO> loadAllUsers() {
        String sql = "select * from smscUsers;";
        ResultSet rs = manager.query(sql);
        ArrayList<smscUsersDTO> data = new ArrayList<>();
        try {
            while (rs.next()) {
                smscUsersDTO dto = new smscUsersDTO(
                        rs.getString("uuid"),
                        rs.getInt("studentNumber"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getObject("sex", Sex.class),
                        rs.getDate("birthDate"),
                        rs.getDate("queryDate"),
                        rs.getDate("updateDate")
                );
                data.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("SQLException. at smscUsersDAOImpl");
        }
        return data;
    }

    @Override
    public void storeSMSCUsers(ArrayList<smscUsersDTO> dto) {

    }
}

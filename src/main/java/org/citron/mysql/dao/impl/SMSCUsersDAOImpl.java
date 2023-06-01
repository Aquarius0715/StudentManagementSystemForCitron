package org.citron.mysql.dao.impl;

import org.citron.mysql.dao.SMSCUsersDAO;
import org.citron.mysql.dto.SMSCUsersDTO;
import org.citron.mysql.manager.impl.MySQLManagerImpl;
import org.citron.struct.Gender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SMSCUsersDAOImpl implements SMSCUsersDAO {
    MySQLManagerImpl manager;

    public SMSCUsersDAOImpl() {
        manager = new MySQLManagerImpl("smscUsersDAO");
    }
    @Override
    public ArrayList<SMSCUsersDTO> loadAllUsers() {
        String sql = "select * from smscUsers;";
        ResultSet rs = manager.query(sql);
        ArrayList<SMSCUsersDTO> data = new ArrayList<>();
        try {
            while (rs.next()) {
                SMSCUsersDTO dto = new SMSCUsersDTO(
                        rs.getString("uuid"),
                        rs.getInt("studentNumber"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        Gender.getByString(rs.getString("sex")),
                        rs.getDate("birthDate"),
                        rs.getDate("queryDate"),
                        rs.getDate("updateDate")
                );
                data.add(dto);
            }
            rs.close();
            manager.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println("SQLException. at smscUsersDAOImpl");
        }
        return data;
    }

    @Override
    public void storeSMSCUsers(ArrayList<SMSCUsersDTO> dtoes) {
        StringBuilder sql = new StringBuilder("INSERT INTO smscUsers(uuid, studentNumber, firstName, lastName, sex, birthDate, queryDate, updateDate) values ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (SMSCUsersDTO dto : dtoes) {
            String buf =
                    "("+
                    "'" + dto.getUUID() + "'," +
                    dto.getStudentNumber() + "," +
                    "'" + dto.getFirstName() + "'," +
                    "'" + dto.getLastName() + "'," +
                    "'" + dto.getGenderAsString() + "'," +
                    "'" + sdf.format(dto.getBirthDate()) + "'," +
                    "'" + sdf2.format(dto.getQueryDate()) + "'," +
                    "'" + sdf2.format(dto.getUpdateDate()) + "'),";
            sql.append(buf);
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(";");
        manager.execute(sql.toString());
        manager.close();
    }
}

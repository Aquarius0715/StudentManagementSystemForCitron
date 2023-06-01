package org.citron.main;

import org.citron.mysql.dao.impl.SMSCUsersDAOImpl;
import org.citron.mysql.dto.SMSCUsersDTO;
import org.citron.struct.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        SMSCUsersDAOImpl dao = new SMSCUsersDAOImpl();
        ArrayList<SMSCUsersDTO> newDTO = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            newDTO.add(new SMSCUsersDTO(
                    UUID.randomUUID().toString(),
                    1,
                    "Kitano",
                    "Masaki",
                    Gender.male,
                    sdf.parse("2004/09/18"),
                    new Date(),
                    new Date()

            ));
            newDTO.add(new SMSCUsersDTO(
                    UUID.randomUUID().toString(),
                    2,
                    "Koshiba",
                    "Sota",
                    Gender.male,
                    sdf.parse("2004/06/02"),
                    new Date(),
                    new Date()
            ));
            newDTO.add(new SMSCUsersDTO(
                    UUID.randomUUID().toString(),
                    3,
                    "Chiba",
                    "Haruto",
                    Gender.male,
                    sdf.parse("2004/02/25"),
                    new Date(),
                    new Date()
            ));
            newDTO.add(new SMSCUsersDTO(
                    UUID.randomUUID().toString(),
                    4,
                    "Kawana",
                    "Taiki",
                    Gender.male,
                    sdf.parse("2004/04/12"),
                    new Date(),
                    new Date()
            ));
            newDTO.add(new SMSCUsersDTO(
                    UUID.randomUUID().toString(),
                    5,
                    "Yamamoto",
                    "Yoshinosuke",
                    Gender.male,
                    sdf.parse("2004/07/02"),
                    new Date(),
                    new Date()
            ));
        } catch (ParseException e) {
            System.out.println("Error at date parse.");
        }
        dao.storeSMSCUsers(newDTO);


        ArrayList<SMSCUsersDTO> dto = dao.loadAllUsers();
        for (SMSCUsersDTO d : dto) {
            System.out.println(d.getUUID());
            System.out.println(d.getFirstName());
            System.out.println(d.getLastName());
            System.out.println(d.getGender());
            System.out.println(d.getStudentNumber());
            System.out.println(d.getBirthDate());
            System.out.println(d.getUpdateDate());
        }
    }
}
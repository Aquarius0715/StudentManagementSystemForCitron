package org.citron.mysql.dto;

import org.citron.struct.Gender;

import java.util.Date;

public class SMSCUsersDTO {
    private String UUID;
    private int studentNumber;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date birthDate;
    private Date queryDate;
    private Date updateDate;

    public SMSCUsersDTO() {

    }

    public SMSCUsersDTO(String UUID, int studentNumber, String firstName, String lastName, Gender gender, Date birthDate, Date queryDate, Date updateDate) {
        this.UUID = UUID;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.queryDate = queryDate;
        this.updateDate = updateDate;
    }

    public String getUUID() {
        return UUID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public String getGenderAsString() {
        if (gender == Gender.male) {
            return "male";
        }
        else if (gender == Gender.female) {
            return "female";
        }
        else {
            return "noAnswer";
        }
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}

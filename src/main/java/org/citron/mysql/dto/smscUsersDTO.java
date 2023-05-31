package org.citron.mysql.dto;

import org.citron.struct.Sex;

import java.util.Date;

public class smscUsersDTO {
    private String UUID;
    private int studentNumber;
    private String firstName;
    private String lastName;
    private Sex sex;
    private Date birthDate;
    private Date queryDate;
    private Date updateDate;

    public smscUsersDTO() {

    }

    public smscUsersDTO(String UUID, int studentNumber, String firstName, String lastName, Sex sex, Date birthDate, Date queryDate, Date updateDate) {
        this.UUID = UUID;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
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

    public Sex getSex() {
        return sex;
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

    public void setSex(Sex sex) {
        this.sex = sex;
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

package com.sambit.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Registration")
public class Reg implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slno;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String userCode;
    @Column
    private String phn;
    @Column
    private String email;
    @Column
    private String dept;
    @Column
    private String gender;
    @Column
    private Date dob;

    public String getUserCode() {
        return userCode;
    }

    @Override
    public String toString() {
        return "Reg{" +
                "slno=" + slno +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userCode='" + userCode + '\'' +
                ", phn='" + phn + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

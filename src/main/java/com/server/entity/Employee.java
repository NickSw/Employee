package com.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String info;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String study;

    @Column
    private String speciality;

    @Column
    private java.sql.Date birthday;

    @Column
    private int code;

    @Column
    private String passport;

    @Column
    private String position1;

    @Column
    private String position2;

    @Column
    private String mail;

    @Column
    private String workplace;

    @Column
    private String decortype;

    @Column
    private String children;

    @Column
    private java.sql.Date enrolldate;

    @Column
    private String enrollorder;

    @Column
    private java.sql.Date enrollorderdate;

    @Column
    private String recofservice;

    @Column
    private String notes;


    public Employee() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getDecortype() {
        return decortype;
    }

    public void setDecortype(String decortype) {
        this.decortype = decortype;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getEnrollorder() {
        return enrollorder;
    }

    public void setEnrollorder(String enrollorder) {
        this.enrollorder = enrollorder;
    }

    public java.sql.Date getEnrolldate() {

        return enrolldate;
    }

    public void setEnrolldate(java.sql.Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public java.sql.Date getEnrollorderdate() {

        return enrollorderdate;
    }

    public void setEnrollorderdate(java.sql.Date enrollorderdate) {
        this.enrollorderdate = enrollorderdate;
    }

    public String getRecofservice() {

        return recofservice;
    }

    public void setRecofservice(String recofservice) {
        this.recofservice = recofservice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
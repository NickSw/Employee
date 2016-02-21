package com.server.dao.impl;

import com.server.dao.EmployeeArchiveDAO;
import com.server.entity.EmployeeArchive;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeArchiveDAOImpl implements EmployeeArchiveDAO {

    public EmployeeArchiveDAOImpl() {
        System.out.println("EmployeeArchiveDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createEmployeeArchive(EmployeeArchive employeeArchive) {
        return (Long) hibernateUtil.create(employeeArchive);
    }

    @Override
    public EmployeeArchive updateEmployeeArchive(EmployeeArchive employeeArchive) {
        return hibernateUtil.update(employeeArchive);
    }

    @Override
    public void deleteEmployeeArchive(long id) {
        EmployeeArchive employeeArchive = new EmployeeArchive();
        employeeArchive.setId(id);
        hibernateUtil.delete(employeeArchive);
    }

    @Override
    public List<EmployeeArchive> getAllEmployeesArchive() {
        return hibernateUtil.fetchAll(EmployeeArchive.class);
    }

    @Override
    public EmployeeArchive getEmployeeArchive(long id) {
        return hibernateUtil.fetchById(id, EmployeeArchive.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeArchive> getAllEmployeesArchive(String employeeNameArchive) {
        String query = "SELECT e.* FROM EmployeesArchive e WHERE e.name like '%"+ employeeNameArchive +"%'";
        List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
        List<EmployeeArchive> employees = new ArrayList<EmployeeArchive>();
        for(Object[] employeeObject: employeeObjects) {
            EmployeeArchive employeeArchive = new EmployeeArchive();
            int id  = (int) employeeObject[0];
            String name = (String) employeeObject[1];
            String phone = (String) employeeObject[2];
            String address = (String) employeeObject[3];
            String study = (String) employeeObject[4];
            java.sql.Date birthday = (java.sql.Date) employeeObject[5];
            int code = (int) employeeObject[6];

            String passport = (String) employeeObject[8];
            String position1 = (String) employeeObject[9];
            String position2 =(String) employeeObject[10];
            String mail = (String) employeeObject[11];
            String workplace = (String) employeeObject[12];
            String speciality = (String) employeeObject[13];
            String decortype = (String) employeeObject[14];
            String children = (String) employeeObject[15];
            java.sql.Date enrolldate = (java.sql.Date) employeeObject[16];
            String enrollorder = (String) employeeObject[17];
            java.sql.Date enrollorderdate = (java.sql.Date) employeeObject[18];
            String recofservice = (String) employeeObject[19];
            String notes = (String) employeeObject[20];

            employeeArchive.setId(id);
            employeeArchive.setName(name);
            employeeArchive.setPhone(phone);
            employeeArchive.setAddress(address);
            employeeArchive.setStudy(study);
            employeeArchive.setSpeciality(speciality);
            employeeArchive.setBirthday(birthday);
            employeeArchive.setCode(code);
            employeeArchive.setPassport(passport);
            employeeArchive.setPosition1(position1);
            employeeArchive.setPosition2(position2);
            employeeArchive.setMail(mail);
            employeeArchive.setWorkplace(workplace);
            employeeArchive.setDecortype(decortype);
            employeeArchive.setChildren(children);
            employeeArchive.setEnrolldate(enrolldate);
            employeeArchive.setEnrollorder(enrollorder);
            employeeArchive.setEnrollorderdate(enrollorderdate);
            employeeArchive.setRecofservice(recofservice);
            employeeArchive.setNotes(notes);


            employees.add(employeeArchive);
        }
        System.out.println(employees);
        return employees;
    }
}
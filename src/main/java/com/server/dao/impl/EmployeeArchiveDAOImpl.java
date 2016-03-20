package com.server.dao.impl;

import com.server.dao.EmployeeArchiveDAO;
import com.server.entity.EmployeeArchive;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
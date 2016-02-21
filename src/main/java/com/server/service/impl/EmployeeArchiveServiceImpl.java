package com.server.service.impl;
import com.server.dao.EmployeeArchiveDAO;
import com.server.entity.EmployeeArchive;
import com.server.service.EmployeeArchiveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeArchiveServiceImpl implements EmployeeArchiveService {

    public EmployeeArchiveServiceImpl() {
        System.out.println("EmployeeArchiveServiceImpl()");
    }

    @Autowired
    private EmployeeArchiveDAO employeeArchiveDAO;

    @Override
    public long createEmployeeArchive(EmployeeArchive employeeArchive) {
        return employeeArchiveDAO.createEmployeeArchive(employeeArchive);
    }
    @Override
    public EmployeeArchive updateEmployeeArchive(EmployeeArchive employeeArchive) {
        return employeeArchiveDAO.updateEmployeeArchive(employeeArchive);
    }
    @Override
    public void deleteEmployeeArchive(int id) {
        employeeArchiveDAO.deleteEmployeeArchive(id);
    }
    @Override
    public List<EmployeeArchive> getAllEmployeesArchive() {
        return employeeArchiveDAO.getAllEmployeesArchive();
    }
    @Override
    public EmployeeArchive getEmployeeArchive(int id) {
        return employeeArchiveDAO.getEmployeeArchive(id);
    }
    @Override
    public List<EmployeeArchive> getAllEmployeesArchive(String employeeNameArchive) {
        return employeeArchiveDAO.getAllEmployeesArchive(employeeNameArchive);
    }
}

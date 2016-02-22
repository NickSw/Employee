package com.server.dao;

import java.util.List;

import com.server.entity.EmployeeArchive;


public interface EmployeeArchiveDAO {
    public long createEmployeeArchive(EmployeeArchive employeeArchive);
    public EmployeeArchive updateEmployeeArchive(EmployeeArchive employeeArchive);
    public void deleteEmployeeArchive(long id);
    public List<EmployeeArchive> getAllEmployeesArchive();
    public EmployeeArchive getEmployeeArchive(long id);
}

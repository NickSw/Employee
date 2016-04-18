package com.server.dao;

import java.util.List;

import com.server.entity.EmployeeArchive;


public interface EmployeeArchiveDAO {
    public void deleteEmployeeArchive(long id);
    public List<EmployeeArchive> getAllEmployeesArchive();
}

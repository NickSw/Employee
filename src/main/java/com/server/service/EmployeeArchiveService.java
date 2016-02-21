
package com.server.service;
import com.server.entity.EmployeeArchive;

import java.util.List;

public interface EmployeeArchiveService {
    public long createEmployeeArchive(EmployeeArchive employeeArchive);
    public EmployeeArchive updateEmployeeArchive(EmployeeArchive employeeArchive);
    public void deleteEmployeeArchive(int id);
    public List<EmployeeArchive> getAllEmployeesArchive();
    public EmployeeArchive getEmployeeArchive(int id);
    public List<EmployeeArchive> getAllEmployeesArchive(String employeeNameArchive);
}

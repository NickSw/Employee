
package com.server.service;
import com.server.entity.EmployeeArchive;

import java.util.List;

public interface EmployeeArchiveService {
    public List<EmployeeArchive> getAllEmployeesArchive();
    public void deleteEmployeeArchive(int id);
}

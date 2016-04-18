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
    public List<EmployeeArchive> getAllEmployeesArchive() {
        return employeeArchiveDAO.getAllEmployeesArchive();
    }

    @Override
    public void deleteEmployeeArchive(int id) {
        employeeArchiveDAO.deleteEmployeeArchive(id);
    }

}

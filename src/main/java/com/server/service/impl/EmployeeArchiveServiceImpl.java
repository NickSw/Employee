package com.server.service.impl;
import com.server.dao.EmployeeArchiveDAO;
import com.server.entity.EmployeeArchive;
import com.server.service.EmployeeArchiveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//TODO: convert all files to utf-8
/**
 * Реализация интерфейса EmployeeArchiveService
 * Методы:
 * Извлечь всех архивных сотрудников из архива сотрудников
 * Удалить архивного сотрудника из архива сотрудников
 *
 * Осуществляется при помощи слоя DAO
 */
@Service
@Transactional
public class EmployeeArchiveServiceImpl implements EmployeeArchiveService {

    public EmployeeArchiveServiceImpl() {
        System.out.println("EmployeeArchiveServiceImpl()");
    }

    @Autowired
    private EmployeeArchiveDAO employeeArchiveDAO;

    /**
     * Извлечение всех архивных сотрудников
     * @return
     */
    @Override
    public List<EmployeeArchive> getAllEmployeesArchive() {
        return employeeArchiveDAO.getAllEmployeesArchive();
    }

    /**
     * Удаление архивного сотрудника
     * @param id
     */
    @Override
    public void deleteEmployeeArchive(int id) {
        employeeArchiveDAO.deleteEmployeeArchive(id);
    }

}

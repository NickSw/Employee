package com.server.dao.impl;

import com.server.dao.EmployeeArchiveDAO;
import com.server.entity.EmployeeArchive;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Реализация интерфейса EmployeeArchiveDAO
 * Методы:
 * Извлечь всех архивных сотрудников из архива сотрудников
 * Удалить архивного сотрудника из архива сотрудников
 *
 * Осуществляется при помощи вспомогательного класса HibernateUtil
 */
@Repository
public class EmployeeArchiveDAOImpl implements EmployeeArchiveDAO {

    public EmployeeArchiveDAOImpl() {
        System.out.println("EmployeeArchiveDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * Извлечь всех архивных сотрудников из таблицы
     * @return
     */
    @Override
    public List<EmployeeArchive> getAllEmployeesArchive() {
        return hibernateUtil.fetchAll(EmployeeArchive.class);
    }

    /**
     * Удалить архивного сотрудника
     * @param id
     */
    @Override
    public void deleteEmployeeArchive(long id) {
        EmployeeArchive employeeArchive = new EmployeeArchive();
        employeeArchive.setId(id);
        hibernateUtil.delete(employeeArchive);
    }

}
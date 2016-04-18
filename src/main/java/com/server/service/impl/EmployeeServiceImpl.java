package com.server.service.impl;
import com.server.dao.EmployeeDAO;
import com.server.entity.Employee;
import com.server.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса EmployeeService
 * Методы:
 * Извлечь всех сотрудников из таблицы сотрудников
 * Извлечь сотрудника из таблицы по id
 * Создать сотрудника
 * Изменить сотрудника
 * Удалить сотрудника
 * Переместить сотрудника в архив
 *
 * Осуществляется при помощи слоя DAO
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl()");
	}
	
    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * Извлечь всех сотрудников
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    /**
     * Извлечь сотрудника по id
     * @param id
     * @return
     */
    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    /**
     * Создать сотрудника
     * @param employee
     * @return
     */
    @Override
    public long createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    /**
     * Изменить сотрудника
     * @param employee
     * @return
     */
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    /**
     * Удалить сотрудника
     * @param id
     */
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    /**
     * Переместить сотрудника в архив
     * @param id
     */
    @Override
    public void moveToEmployeeArchive(int id) {employeeDAO.moveToEmployeeArchive(id);}
}

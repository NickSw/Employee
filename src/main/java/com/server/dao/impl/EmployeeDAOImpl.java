package com.server.dao.impl;

import com.server.dao.EmployeeDAO;
import com.server.entity.Employee;
import com.server.util.HibernateUtil;
import org.apache.commons.lang.SerializationUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Реализация интерфейса EmployeeDAO
 * Методы:
 * Извлечь всех сотрудников из таблицы сотрудников
 * Извлечь сотрудника из таблицы по id
 * Создать сотрудника
 * Изменить сотрудника
 * Удалить сотрудника
 * Переместить сотрудника в архив
 *
 * Осуществляется при помощи вспомогательного класса HibernateUtil
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
	public EmployeeDAOImpl() {
    	System.out.println("EmployeeDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    /**
     * Извлечь всех сотрудников
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return hibernateUtil.fetchAll(Employee.class);
    }

    /**
     * Извлечь сотрудника по id
     * @param id
     * @return
     */
    @Override
    public Employee getEmployee(long id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

    /**
     * Создать сотрудника
     * @param employee
     * @return
     */
    @Override
    public long createEmployee(Employee employee) {
        return (Long) hibernateUtil.create(employee);
    }

    /**
     * Обновить сотрудника
     * @param employee
     * @return
     */
    @Override
    public Employee updateEmployee(Employee employee) {        
        return hibernateUtil.update(employee);
    }

    /**
     * Удалить сотрудника
     * @param id
     */
    @Override
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        hibernateUtil.delete(employee);
    }

    /**
     * Переместить запись сотрудника в таблицу архив сотрудников
     * TODO: сделать запрос языком hql, помещать в метод только сущность
     * @param id
     */
    @Override
    public void moveToEmployeeArchive(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        /**запрос на копирование*/
        String query = "INSERT INTO emp_archive SELECT e.* FROM Employees e WHERE e.id =" + id + "";
        /**метод, копирующий запись в таблицу архив сотрудников и удаляющий текущ. запись из таблицы*/
        hibernateUtil.move(query, employee);
    }

}
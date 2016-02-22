package com.server.dao.impl;

import com.server.dao.EmployeeDAO;
import com.server.entity.Employee;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    
	public EmployeeDAOImpl() {
    	System.out.println("EmployeeDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createEmployee(Employee employee) {
        return (Long) hibernateUtil.create(employee);
    }
    
    @Override
    public Employee updateEmployee(Employee employee) {        
        return hibernateUtil.update(employee);
    }
    
    @Override
    public void deleteEmployee(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        hibernateUtil.delete(employee);
    }

    @Override
    public void moveToEmployeeArchive(long id) {
        Employee employee = new Employee();
        employee.setId(id);
        String query = "INSERT INTO emp_archive SELECT e.* FROM Employees e WHERE e.id =" + id + "";
        hibernateUtil.move(query, employee);
    }

    @Override
    public List<Employee> getAllEmployees() {        
        return hibernateUtil.fetchAll(Employee.class);
    }
    
    @Override
    public Employee getEmployee(long id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

}
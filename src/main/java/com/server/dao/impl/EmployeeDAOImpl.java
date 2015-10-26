package com.server.dao.impl;

import com.server.dao.EmployeeDAO;
import com.server.entity.Employee;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public List<Employee> getAllEmployees() {        
        return hibernateUtil.fetchAll(Employee.class);
    }
    
    @Override
    public Employee getEmployee(long id) {
        return hibernateUtil.fetchById(id, Employee.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(String employeeName) { 
		String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
		List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
		List<Employee> employees = new ArrayList<Employee>();
		for(Object[] employeeObject: employeeObjects) {
			Employee employee = new Employee();
			int id  = (int) employeeObject[0];
			String name = (String) employeeObject[1];
			String phone = (String) employeeObject[2];
            String address = (String) employeeObject[3];
            String study = (String) employeeObject[4];
            java.sql.Date birthday = (java.sql.Date) employeeObject[5];
            int code = (int) employeeObject[6];

            employee.setId(id);
			employee.setName(name);
            employee.setPhone(phone);
            employee.setAddress(address);
            employee.setStudy(study);
            employee.setBirthday(birthday);
            employee.setCode(code);

			employees.add(employee);
		}
		System.out.println(employees);
		return employees;
	}
}
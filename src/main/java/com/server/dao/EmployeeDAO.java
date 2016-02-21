package com.server.dao;

import java.util.List;

import com.server.entity.Employee;


public interface EmployeeDAO {
	public long createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);
    public void moveToEmployeeArchive(long id);
	//public List<Employee> getAllEmployees(String employeeName);
}

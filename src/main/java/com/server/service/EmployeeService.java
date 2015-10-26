
package com.server.service;
import com.server.entity.Employee;

import java.util.List;

public interface EmployeeService {
	public long createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
	public List<Employee> getAllEmployees(String employeeName);
}

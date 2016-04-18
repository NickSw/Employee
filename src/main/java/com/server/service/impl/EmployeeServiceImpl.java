package com.server.service.impl;
import com.server.dao.EmployeeDAO;
import com.server.entity.Employee;
import com.server.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ���������� ���������� EmployeeService
 * ������:
 * ������� ���� ����������� �� ������� �����������
 * ������� ���������� �� ������� �� id
 * ������� ����������
 * �������� ����������
 * ������� ����������
 * ����������� ���������� � �����
 *
 * �������������� ��� ������ ���� DAO
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
     * ������� ���� �����������
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    /**
     * ������� ���������� �� id
     * @param id
     * @return
     */
    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    /**
     * ������� ����������
     * @param employee
     * @return
     */
    @Override
    public long createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    /**
     * �������� ����������
     * @param employee
     * @return
     */
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    /**
     * ������� ����������
     * @param id
     */
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    /**
     * ����������� ���������� � �����
     * @param id
     */
    @Override
    public void moveToEmployeeArchive(int id) {employeeDAO.moveToEmployeeArchive(id);}
}

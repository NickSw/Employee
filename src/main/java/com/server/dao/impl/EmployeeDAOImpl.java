package com.server.dao.impl;

import com.server.dao.EmployeeDAO;
import com.server.entity.Employee;
import com.server.entity.EmployeeArchive;
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

	/*@SuppressWarnings("unchecked")
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
            String passport = (String) employeeObject[8];
            String position1 = (String) employeeObject[9];
            String position2 =(String) employeeObject[10];
            String mail = (String) employeeObject[11];
            String workplace = (String) employeeObject[12];
            String speciality = (String) employeeObject[13];
            String decortype = (String) employeeObject[14];
            String children = (String) employeeObject[15];
            java.sql.Date enrolldate = (java.sql.Date) employeeObject[16];
            String enrollorder = (String) employeeObject[17];
            java.sql.Date enrollorderdate = (java.sql.Date) employeeObject[18];
            String recofservice = (String) employeeObject[19];
            String notes = (String) employeeObject[20];

            employee.setId(id);
			employee.setName(name);
            employee.setPhone(phone);
            employee.setAddress(address);
            employee.setStudy(study);
            employee.setSpeciality(speciality);
            employee.setBirthday(birthday);
            employee.setCode(code);
            employee.setPassport(passport);
            employee.setPosition1(position1);
            employee.setPosition2(position2);
            employee.setMail(mail);
            employee.setWorkplace(workplace);
            employee.setDecortype(decortype);
            employee.setChildren(children);
            employee.setEnrolldate(enrolldate);
            employee.setEnrollorder(enrollorder);
            employee.setEnrollorderdate(enrollorderdate);
            employee.setRecofservice(recofservice);
            employee.setNotes(notes);


			employees.add(employee);
		}
		System.out.println(employees);
		return employees;
	}*/
}
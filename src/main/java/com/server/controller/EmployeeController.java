package com.server.controller;
import com.server.entity.Employee;
import com.server.entity.WorkPlace;
import com.server.service.EmployeeService;

import com.server.service.WorkPlaceService;
import com.server.util.FileBean;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WorkPlaceService workPlaceService;

    @RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
    	logger.info("Creating Employee. Data: " + employee);
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeForm", "model", model);
    }

    @RequestMapping("editEmployee")
    public ModelAndView editEmployee(@RequestParam int id, @ModelAttribute Employee employee) {
    	logger.info("Updating the Employee for the Id "+id);
        employee = employeeService.getEmployee(id);
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employee", employee);
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeForm", "model", model);
    }

    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
    	logger.info("Saving the Employee. Data : " + employee);
        //allow blank date
        if (employee.getBirthdayString() == "") employee.setBirthday(null);
        if (employee.getEnrolldateString() =="") employee.setEnrolldate(null);
        if (employee.getEnrollorderdateString() == "") employee.setEnrolldateString(null);
        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int id) {
    	logger.info("Deleting the Employee. Id : "+id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping(value = {"getAllEmployees", "/"})
    public ModelAndView getAllEmployees(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
    	logger.info("Getting the all Employees.");
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employeeList", employeeList);
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeList", "model", model);
    }

    @RequestMapping("archiveEmployee")
    public ModelAndView archiveEmployee(@RequestParam int id) {
        logger.info("Archiving the Employee. Id : " + id);
        employeeService.moveToEmployeeArchive(id);
        return new ModelAndView("redirect:getAllEmployeesArchive");
    }

    @RequestMapping("getEmployee")
    public ModelAndView getEmployee(@RequestParam int id, @ModelAttribute Employee employee){
        logger.info("Getting Employee. Id : " + id);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeCard", "employeeObject", employee);
    }
}
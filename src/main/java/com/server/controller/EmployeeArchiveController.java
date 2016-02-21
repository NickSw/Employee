package com.server.controller;
import com.server.entity.EmployeeArchive;
import com.server.service.EmployeeArchiveService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class EmployeeArchiveController {

    private static final Logger logger = Logger.getLogger(EmployeeArchiveController.class);

    public EmployeeArchiveController() {
        System.out.println("EmployeeArchiveController()");
    }

    @Autowired
    private EmployeeArchiveService employeeArchiveService;

    @RequestMapping("createEmployeeArchive")
    public ModelAndView createEmployeeArchive(@ModelAttribute EmployeeArchive employeeArchive) {
        logger.info("Creating EmployeeArchive. Data: " + employeeArchive);
        return new ModelAndView("employeeArchiveForm");
    }

    @RequestMapping("editEmployeeArchive")
    public ModelAndView editEmployeeArchive(@RequestParam int id, @ModelAttribute EmployeeArchive employeeArchive) {
        logger.info("Updating the EmployeeArchive for the Id " + id);
        employeeArchive = employeeArchiveService.getEmployeeArchive(id);
        return new ModelAndView("employeeArchiveForm", "employeeArchiveObject", employeeArchive);
    }

    @RequestMapping("saveEmployeeArchive")
    public ModelAndView saveEmployeeArchive(@ModelAttribute EmployeeArchive employeeArchive) {
        logger.info("Saving the EmployeeArchive. Data : " + employeeArchive);
        if(employeeArchive.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
            employeeArchiveService.createEmployeeArchive(employeeArchive);
        } else {
            employeeArchiveService.updateEmployeeArchive(employeeArchive);
        }
        return new ModelAndView("redirect:getAllEmployeesArchive");
    }

    @RequestMapping("deleteEmployeeArchive")
    public ModelAndView deleteEmployeeArchive(@RequestParam int id) {
        logger.info("Deleting the EmployeeArchive. Id : " + id);
        employeeArchiveService.deleteEmployeeArchive(id);
        return new ModelAndView("redirect:getAllEmployeesArchive");
    }

    @RequestMapping(value = {"getAllEmployeesArchive", "/"})
    public ModelAndView getAllEmployeesArchive() {
        logger.info("Getting the all EmployeesArchive.");
        List<EmployeeArchive> employeeArchiveList = employeeArchiveService.getAllEmployeesArchive();
        return new ModelAndView("employeeArchiveList", "employeeArchiveList", employeeArchiveList);
    }

    @RequestMapping("searchEmployeeArchive")
    public ModelAndView searchEmployeeArchive(@RequestParam("searchName") String searchName) {
        logger.info("Searching the EmployeeArchive. Employee Names: "+searchName);
        List<EmployeeArchive> employeeArchiveList = employeeArchiveService.getAllEmployeesArchive(searchName);
        return new ModelAndView("employeeArchiveList", "employeeArchiveList", employeeArchiveList);
    }
}
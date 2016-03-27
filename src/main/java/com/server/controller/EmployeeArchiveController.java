package com.server.controller;
import com.server.entity.EmployeeArchive;
import com.server.entity.WorkPlace;
import com.server.service.EmployeeArchiveService;

import com.server.service.WorkPlaceService;
import com.server.util.FileBean;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WorkPlaceService workPlaceService;

    @RequestMapping("deleteEmployeeArchive")
    public ModelAndView deleteEmployeeArchive(@RequestParam int id) {
        logger.info("Deleting the EmployeeArchive. Id : " + id);
        employeeArchiveService.deleteEmployeeArchive(id);
        return new ModelAndView("redirect:getAllEmployeesArchive");
    }

    @RequestMapping(value = {"getAllEmployeesArchive", "/"})
    public ModelAndView getAllEmployeesArchive(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all EmployeesArchive.");
        List<EmployeeArchive> employeeArchiveList = employeeArchiveService.getAllEmployeesArchive();
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employeeArchiveList", employeeArchiveList);
        model.put("workPlaceList", workPlaceList);
        return new ModelAndView("employeeArchiveList", "model", model);
    }

}
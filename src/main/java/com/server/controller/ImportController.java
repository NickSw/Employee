package com.server.controller;

import com.server.service.*;
import com.server.util.FileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImportController {

    @Autowired
    private MovementImportService movementImportService;

    @Autowired
    private EmployeeImportService employeeImportService;

    @Autowired
    private OrderTypeImportService orderTypeImportService;

    @Autowired
    private WorkPlaceImportService workPlaceImportService;

    @RequestMapping(value = "/importMovement", method = RequestMethod.POST)
    public ModelAndView importMovementXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        movementImportService.importMovement(fileBean);
        return new ModelAndView("redirect:getAllMovements");
    }

    @RequestMapping(value = "/importEmployee", method = RequestMethod.POST)
    public ModelAndView importEmployeeXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        employeeImportService.importEmployee(fileBean);
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping(value = "/importOrderType", method = RequestMethod.POST)
    public ModelAndView importOrderTypeXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        orderTypeImportService.importOrderType(fileBean);
        return new ModelAndView("redirect:getAllOrderTypes");
    }

    @RequestMapping(value = "/importWorkPlace", method = RequestMethod.POST)
    public ModelAndView importWorkPlaceXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        workPlaceImportService.importWorkPlace(fileBean);
        return new ModelAndView("redirect:getAllWorkPlaces");
    }

}
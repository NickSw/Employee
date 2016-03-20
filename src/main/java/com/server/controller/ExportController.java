package com.server.controller;

import javax.servlet.http.HttpServletResponse;

import com.server.service.EmployeeExportService;
import com.server.service.MovementExportService;
import com.server.service.OrderTypeExportService;
import com.server.service.WorkPlaceExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/export")
public class ExportController {

    @Autowired
    EmployeeExportService employeeExportService;

    @Autowired
    MovementExportService movementExportService;

    @Autowired
    WorkPlaceExportService workPlaceExportService;

    @Autowired
    OrderTypeExportService orderTypeExportService;

    /**
     * Downloads the report as an Excel format.
     * <p>
     * Make sure this method doesn't return any model. Otherwise, you'll get
     * an "IllegalStateException: getOutputStream() has already been called for this response"
     */

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public void getEmployeeXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse
        employeeExportService.exportEmployee(response);
    }

    @RequestMapping(value = "/movement", method = RequestMethod.GET)
    public void getMovementXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        movementExportService.exportMovement(response);
    }

    @RequestMapping(value = "/workplace", method = RequestMethod.GET)
    public void getWorkPlaceXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        workPlaceExportService.exportWorkPlace(response);
    }

    @RequestMapping(value = "/ordertype", method = RequestMethod.GET)
    public void getOrderTypeXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        orderTypeExportService.exportOrderType(response);
    }
}
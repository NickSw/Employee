package com.server.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.server.service.EmployeeImportService;
import com.server.service.impl.employeeExport.EmployeeImportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/export")
public class ExportController {

    @Autowired
    EmployeeImportService employeeImportService;

    /**
     * Downloads the report as an Excel format.
     * <p>
     * Make sure this method doesn't return any model. Otherwise, you'll get
     * an "IllegalStateException: getOutputStream() has already been called for this response"
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public void getEmployeeXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse
        employeeImportService.importEmployee(response);
    }
}
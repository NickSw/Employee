package com.server.controller;

import com.server.service.EmployeeArchiveClearService;
import com.server.service.MovementArchiveClearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/clear")
public class ClearArchiveController {

    @Autowired
    EmployeeArchiveClearService employeeArchiveClearService;

    @Autowired
    MovementArchiveClearService movementArchiveClearService;


    /**
     * Downloads the report as an Excel format.
     * <p>
     * Make sure this method doesn't return any model. Otherwise, you'll get
     * an "IllegalStateException: getOutputStream() has already been called for this response"
     */

    @RequestMapping(value = "/employeeArchive", method = RequestMethod.GET)
    public void clearEmployeeArchive(HttpServletResponse response, Model model) throws ClassNotFoundException {
        // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse
        employeeArchiveClearService.clearEmployeeArchive(response);
    }

    @RequestMapping(value = "/movementArchive", method = RequestMethod.GET)
    public void clearMovementArchive(HttpServletResponse response, Model model) throws ClassNotFoundException {
        // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse
        movementArchiveClearService.clearMovementArchive(response);
    }

}

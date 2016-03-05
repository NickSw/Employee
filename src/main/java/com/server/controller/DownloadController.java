package com.server.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import com.server.service.download.EmployeesDownloadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/download")
public class DownloadController {


    @Resource(name="employeesDownloadService")
    private EmployeesDownloadService employeesDownloadService;

    /**
     * Downloads the report as an Excel format.
     * <p>
     * Make sure this method doesn't return any model. Otherwise, you'll get
     * an "IllegalStateException: getOutputStream() has already been called for this response"
     */
    @RequestMapping(value = "/xls", method = RequestMethod.GET)
    public void getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse
        employeesDownloadService.downloadXLS(response);
    }
}
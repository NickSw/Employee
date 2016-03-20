package com.server.controller;

import com.server.service.MovementImportService;
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

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String displayForm(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        return "importForm";
    }


    @RequestMapping(value = "/xls", method = RequestMethod.POST)
    public ModelAndView importXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        movementImportService.importFile(fileBean);
        return new ModelAndView("redirect:getAllMovements");
    }

}
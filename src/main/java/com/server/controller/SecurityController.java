package com.server.controller;

import com.server.entity.Admin;
import com.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/")
public class SecurityController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView model = new ModelAndView();
        Admin admin = adminService.getCredentials();
        model.addObject(admin);
        model.setViewName("login");
        return model;
    }

    @RequestMapping("changePassword")
    public ModelAndView changePassword(@ModelAttribute Admin admin) {
        admin = adminService.getCredentials();
        return new ModelAndView("changePasswordForm", "adminObject", admin);
    }

    @RequestMapping("saveNewPassword")
    public ModelAndView saveWorkPlace(@ModelAttribute Admin admin) {
        adminService.updateCredentials(admin);
        return new ModelAndView("redirect:getAllEmployees");
    }

}
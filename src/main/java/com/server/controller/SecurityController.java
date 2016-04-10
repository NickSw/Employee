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
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Неверное имя пользователя или пароль!");
        }
        model.setViewName("login");
        return model;
    }

    //сначала дадим вьюху на эдит как в воркплейсе
    @RequestMapping("changePassword")
    public ModelAndView changePassword(@ModelAttribute Admin admin) {
        admin = adminService.getCredentials();
        return new ModelAndView("changePasswordForm", "adminObject", admin);
    }

    //потом через сущность поменяю пароль
     @RequestMapping("saveNewPassword")
    public ModelAndView saveWorkPlace(@ModelAttribute Admin admin) {
        adminService.updateCredentials(admin);
        return new ModelAndView("redirect:getAllEmployees");
    }


    /*
    @RequestMapping("/changePassword")
    public void changePassword(String password) {
        adminService.changePassword(password);
    }
   /* @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody
    String getTime() {
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }*/

}
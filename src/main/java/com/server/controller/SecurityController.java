package com.server.controller;

import com.server.entity.Admin;
import com.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Контролер для безопасности
 * Методы:
 * Предоставление формы логина
 * Изменение пароля
 * Сохранение новго пароля
 * Сброс пароля
 */
@Controller
@RequestMapping("/")
public class SecurityController {

    @Autowired
    AdminService adminService;

    /**
     * Предоставление формы логина
     * TODO: return в новом виде
     * TODO: пересмотреть безопасноть
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView model = new ModelAndView();
        /**Помещение на форму логина и пароля админа для проверки на странице*/
        Admin admin = adminService.getCredentials();
        model.addObject(admin);
        model.setViewName("login");
        return model;
        // return new ModelAndView("login", "model", admin);
    }

    /**
     * Замена пароля
     * @param admin
     * @return
     */
    @RequestMapping("changePassword")
    public ModelAndView changePassword(@ModelAttribute Admin admin) {
        /**Помещение на форму замены пароля и пароля админа для проверки на странице*/
        admin = adminService.getCredentials();
        return new ModelAndView("changePasswordForm", "adminObject", admin);
    }

    /**
     * Сохранение нового пароля
     * @param admin
     * @return
     */
    @RequestMapping("saveNewPassword")
    public ModelAndView saveNewPassword(@ModelAttribute Admin admin) {
        adminService.updateCredentials(admin);
        return new ModelAndView("redirect:getAllEmployees");
    }

    /**
     * Сброс пароля
     * @return
     */
    @RequestMapping("resetPassword")
    public ModelAndView resetPassword() {
        adminService.resetPassword();
        return new ModelAndView("redirect:getAllEmployees");
    }
}
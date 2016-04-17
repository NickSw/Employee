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

/**
 * Контроллер для экспорта таблиц в архив
 * Методы:
 * Экспорт таблицы сотрудников
 * Экспорт таблицы приказов по сотрудникам
 * Экспорт таблицы мест работы
 * Экспорт таблицы типов приказов
 */
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
     * Метод для экспорта таблицы сотрудников
     * Этот метод не должен возвращать Model. Иначе, будет искочение
     * "IllegalStateException: getOutputStream() has already been called for this response"
     * @param response
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public void getEmployeeXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        /** Делегирование сервису exportEmployee. Make sure to pass an instance of HttpServletResponse*/
        employeeExportService.exportEmployee(response);
    }

    /**
     * Метод для экспорта таблицы приказов по сотрудникам
     * Этот метод не должен возвращать Model. Иначе, будет искочение
     * "IllegalStateException: getOutputStream() has already been called for this response"
     * @param response
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/movement", method = RequestMethod.GET)
    public void getMovementXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        /** Делегирование сервису exportMovement. Make sure to pass an instance of HttpServletResponse*/
        movementExportService.exportMovement(response);
    }

    /**
     * Метод для экспорта таблицы мест работы
     * Этот метод не должен возвращать Model. Иначе, будет искочение
     * "IllegalStateException: getOutputStream() has already been called for this response"
     * @param response
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/workplace", method = RequestMethod.GET)
    public void getWorkPlaceXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        /** Делегирование сервису exportWorkPlace. Make sure to pass an instance of HttpServletResponse*/
        workPlaceExportService.exportWorkPlace(response);
    }

    /**
     * Метод для экспорта таблицы типов приказов
     * Этот метод не должен возвращать Model. Иначе, будет искочение
     * "IllegalStateException: getOutputStream() has already been called for this response"
     * @param response
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/ordertype", method = RequestMethod.GET)
    public void getOrderTypeXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
        /** Делегирование сервису exportOrderType. Make sure to pass an instance of HttpServletResponse*/
        orderTypeExportService.exportOrderType(response);
    }
}
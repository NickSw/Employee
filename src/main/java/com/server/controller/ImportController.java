package com.server.controller;

import com.server.service.*;
import com.server.util.FileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер для импорта excel документов
 * Методы:
 * Импорт документа xls для таблицы сотрудников
 * Импорт документа xls для таблицы приказы по сотрудникам
 * Импорт документа xls для таблицы мест работы
 * Импорт документа xls для таблицы типы приказов
 * Перенаправление на страницу помощи в случае ошибки
 */
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


    /**
     * Импорт документа xls для таблицы сотрудников
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = "/importEmployee", method = RequestMethod.POST)
    public ModelAndView importEmployeeXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        employeeImportService.importEmployee(fileBean);
        return new ModelAndView("redirect:getAllEmployees");
    }

    /**
     * Импорт документа xls для таблицы приказы по сотрудникам
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = "/importMovement", method = RequestMethod.POST)
    public ModelAndView importMovementXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        movementImportService.importMovement(fileBean);
        return new ModelAndView("redirect:getAllMovements");
    }


    /**
     * Импорт документа xls для таблицы типы приказов
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = "/importOrderType", method = RequestMethod.POST)
    public ModelAndView importOrderTypeXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        orderTypeImportService.importOrderType(fileBean);
        return new ModelAndView("redirect:getAllOrderTypes");
    }

    /**
     * Импорт документа xls для таблицы мест работы
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = "/importWorkPlace", method = RequestMethod.POST)
    public ModelAndView importWorkPlaceXLS(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        workPlaceImportService.importWorkPlace(fileBean);
        return new ModelAndView("redirect:getAllWorkPlaces");
    }

    /**
     * Перенаправления на страницу помощи в случае исключения
     * TODO: ловить исключение в конкретном методе
     * @param ex
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleCustomException(NullPointerException ex) {
        return new ModelAndView("redirect:help#import");
    }
}
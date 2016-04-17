package com.server.controller;

import com.server.service.EmployeeArchiveClearService;
import com.server.service.MovementArchiveClearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;

/**
 * Контроллер для экспорта и очистки таблиц Архивов сотрудников и приказов.
 * Методы:
 * Экспорт и очистка таблицы архив сотрудников
 * Экспорт и очистка таблицы архив приказов по сотрудникам
 */
@Controller
@RequestMapping("/clear")
public class ClearArchiveController {

    @Autowired
    EmployeeArchiveClearService employeeArchiveClearService;

    @Autowired
    MovementArchiveClearService movementArchiveClearService;

    /**
     * Метод для экспорта и очистки таблицы архив сотрудников
     * Этот метод не должен возвращать Model. Иначе, будет искочение
     * "IllegalStateException: getOutputStream() has already been called for this response"
     * @param response
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/employeeArchive", method = RequestMethod.GET)
    public void clearEmployeeArchive(HttpServletResponse response, Model model) throws ClassNotFoundException {
        /** Делегирование сервису clearEmployeeArchive. Make sure to pass an instance of HttpServletResponse*/
        employeeArchiveClearService.clearEmployeeArchive(response);
    }

    /**
     * Метод для экспорта и очистки таблицы архив приказов
     * Этот метод не должен возвращать Model. Иначе, будет искочение
     * "IllegalStateException: getOutputStream() has already been called for this response"
     * @param response
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/movementArchive", method = RequestMethod.GET)
    public void clearMovementArchive(HttpServletResponse response, Model model) throws ClassNotFoundException {
        /** Делегирование сервису clearMovementArchive. Make sure to pass an instance of HttpServletResponse*/
        movementArchiveClearService.clearMovementArchive(response);
    }

}

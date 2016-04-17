package com.server.controller;
import com.server.entity.WorkPlace;
import com.server.service.WorkPlaceService;

import com.server.util.FileBean;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Контроллер для таблицы мест работы
 * Методы:
 * Извлечение всех мест работы из таблицы и помещение на страницу
 * Создание места работы
 * Редактирование места работы
 * Удаление места работы
 * Сохранение места работы
 */
@Controller
@RequestMapping("/")
public class WorkPlaceController {

    private static final Logger logger = Logger.getLogger(WorkPlaceController.class);

    public WorkPlaceController() {
        System.out.println("WorkPlaceController()");
    }

    @Autowired
    private WorkPlaceService workPlaceService;

    /**
     * Извлечение всех мест работы из таблицы
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = {"getAllWorkPlaces", "/"})
    public ModelAndView getAllWorkPlaces(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all WorkPlaces.");
        List<WorkPlace> workPlaceList = workPlaceService.getAllWorkPlaces();
        return new ModelAndView("workPlaceList", "workPlaceList", workPlaceList);
    }

    /**
     * Создание места работы
     * @param workPlace
     * @return
     */
    @RequestMapping("createWorkPlace")
    public ModelAndView createWorkPlace(@ModelAttribute WorkPlace workPlace) {
        logger.info("Creating WorkPlace. Data: " + workPlace);
        return new ModelAndView("workPlaceForm");
    }

    /**
     * Редактирование места работы
     * @param id
     * @param workPlace
     * @return
     */
    @RequestMapping("editWorkPlace")
    public ModelAndView editWorkPlace(@RequestParam int id, @ModelAttribute WorkPlace workPlace) {
        logger.info("Updating the WorkPlace for the Id " + id);
        workPlace = workPlaceService.getWorkPlace(id);
        return new ModelAndView("workPlaceForm", "workPlaceObject", workPlace);
    }

    /**
     * Сохранение места работы
     * @param workPlace
     * @return
     */
    @RequestMapping("saveWorkPlace")
    public ModelAndView saveWorkPlace(@ModelAttribute WorkPlace workPlace) {
        logger.info("Saving the WorkPlace. Data : " + workPlace);
        /**
         * Проверка редактировали места работы или создавали новое
         * Если workPlace id 0, тогда создаем сотрудника, если нет, то обновляем существующего
         */
        if(workPlace.getId() == 0){
            workPlaceService.createWorkPlace(workPlace);
        } else {
            workPlaceService.updateWorkPlace(workPlace);
        }
        return new ModelAndView("redirect:getAllWorkPlaces");
    }

    /**
     * Удаление места работы
     * @param id
     * @return
     */
    @RequestMapping("deleteWorkPlace")
    public ModelAndView deleteWorkPlace(@RequestParam int id) {
        logger.info("Deleting the WorkPlace. Id : " + id);
        workPlaceService.deleteWorkPlace(id);
        return new ModelAndView("redirect:getAllWorkPlaces");
    }


}
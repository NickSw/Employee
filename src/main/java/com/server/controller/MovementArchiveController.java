package com.server.controller;
import com.server.entity.MovementArchive;
import com.server.entity.OrderType;
import com.server.service.MovementArchiveService;
import com.server.service.OrderTypeService;
import com.server.util.FileBean;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Контроллер для таблицы Архив приказов по сотрудникам
 * Методы:
 * Извлечение всех архивных приказов по сотрудникам из таблицы и помещение на страницу
 * Удаление архивного приказа
 */
@Controller
@RequestMapping("/")
public class MovementArchiveController {

    private static final Logger logger = Logger.getLogger(MovementArchiveController.class);

    public MovementArchiveController() {
        System.out.println("MovementArchiveController()");
    }

    @Autowired
    private MovementArchiveService movementArchiveService;

    @Autowired
    private OrderTypeService orderTypeService;

    /**
     * Извлечение всех архивных типов приказов из таблицы
     * Извлечение типов приказов для фильтра
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = {"getAllMovementsArchive", "/"})
    public ModelAndView getAllMovementsArchive(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all MovementsArchive.");
        /**Извлечение архивного*/
        List<MovementArchive> movementArchiveList = movementArchiveService.getAllMovementsArchive();
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("movementArchiveList",movementArchiveList);
        model.put("orderTypeList",orderTypeList);
        return new ModelAndView("movementArchiveList", "model", model);
    }

    /**
     * Удаление архивного приказа из таблицы
     * @param id
     * @return
     */
    @RequestMapping("deleteMovementArchive")
    public ModelAndView deleteMovementArchive(@RequestParam int id) {
        logger.info("Deleting the MovementArchive. Id : "+id);
        movementArchiveService.deleteMovementArchive(id);
        return new ModelAndView("redirect:getAllMovementsArchive");
    }

}

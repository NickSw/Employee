package com.server.controller;
import com.server.entity.Employee;
import com.server.entity.Movement;
import com.server.entity.OrderType;
import com.server.service.EmployeeService;
import com.server.service.MovementService;
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
 * Контроллер для таблицы приказы по сотрудникам
 * Методы:
 * Извлечение всех приказов из таблицы и помещение на страницу
 * Создание приказа
 * Редактирование приказа
 * Удаление приказа
 * Сохранение приказа
 * Перемещение приказа в таблицу архив приказов
 * Копирование приказа по сотруднику в одной таблице
 */
@Controller
@RequestMapping("/")
public class MovementController {

    private static final Logger logger = Logger.getLogger(MovementController.class);

    public MovementController() {
        System.out.println("MovementController()");
    }

    @Autowired
    private MovementService movementService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderTypeService orderTypeService;

    /**
     * Извлечение всех приказов по сотрудникам из таблицы
     * Извлечение типов приказов для фильтра
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = {"getAllMovements", "/"})
    public ModelAndView getAllMovements(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all Movements.");
        List<Movement> movementList = movementService.getAllMovements();
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("movementList",movementList);
        model.put("orderTypeList",orderTypeList);
        return new ModelAndView("movementList", "model", model);
    }

    /**
     * Создание приказа по сотруднику
     * Извлечение списка сотрудников
     * Извлечение типов приказа
     * @param movement
     * @return
     */
    @RequestMapping("createMovement")
    public ModelAndView createMovement(@ModelAttribute Movement movement) {
        logger.info("Creating Movement. Data: " + movement);
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employeeList", employeeList);
        model.put("orderTypeList",orderTypeList);
        return new ModelAndView("movementForm", "model", model);
    }

    /**
     * Редактирование типа приказа
     * Извлечение списка сотрудников
     * Извлечение типов приказов
     * TODO: добавить соответсвующее значение при редактировании первым, пустое значение
     * @param id
     * @param movement
     * @return
     */
    @RequestMapping("editMovement")
    public ModelAndView editMovement(@RequestParam int id,@ModelAttribute Movement movement){
        logger.info("Update the Movement for the Id" + id);
        /**Извлечение приказа для редактирования*/
        movement = movementService.getMovement(id);
        /**Извлечение всех сотрудников*/
        List<Employee> employeeList = employeeService.getAllEmployees();
        /**Извлечение всех типов приказов*/
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("movement", movement);
        model.put("employeeList", employeeList);
        model.put("orderTypeList",orderTypeList);
        return new ModelAndView("movementForm", "model", model);
    }

    /**
     * Сохраниение приказа по сотруднику в базу
     * @param movement
     * @return
     */
    @RequestMapping("saveMovement")
    public ModelAndView saveMovement(@ModelAttribute Movement movement){
        logger.info("Saving the Movement. Data: " + movement);
        /**
         * Проверка редактировали приказ или создавали новый
         * Если movement id 0, тогда создаем сотрудника, если нет, то обновляем существующего
         */
        if(movement.getId() == 0) {
            movementService.createMovement(movement);
        } else {
          movementService.updateMovement(movement);
        }
        return new ModelAndView("redirect:getAllMovements");
    }

    /**
     * Удаление приказа по сотруднику
     * @param id
     * @return
     */
    @RequestMapping("deleteMovement")
    public ModelAndView deleteMovement(@RequestParam int id) {
        logger.info("Deleting the Movement. Id : "+id);
        movementService.deleteMovement(id);
        return new ModelAndView("redirect:getAllMovements");
    }

    /**
     * Перемещение приказа по сотруднику в архив
     * @param id
     * @return
     */
    @RequestMapping("archiveMovement")
    public ModelAndView archiveMovement(@RequestParam int id) {
        logger.info("Archiving the Movement. Id : " + id);
        movementService.moveToMovementArchive(id);
        return new ModelAndView("redirect:getAllMovementsArchive");
    }

    /**
     * Копирование приказа по сотруднику в одной таблице
     * @param id
     * @return
     */
    @RequestMapping("copyMovement")
    public ModelAndView copyMovement(@RequestParam int id) {
        logger.info("Copying the Movement. Id : " + id);
        movementService.copyMovement(id);
        return new ModelAndView("redirect:getAllMovements");
    }
}

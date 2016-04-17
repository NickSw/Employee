package com.server.controller;
import com.server.entity.OrderType;
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

import java.util.List;

/**
 * Контроллер для таблицы типов приказов
 * Методы:
 * Извлечение всех типов приказов из таблицы и помещение на страницу
 * Создание типа приказа
 * Редактирование типа приказа
 * Удаление типа приказа
 * Сохранение типа приказа
 */
@Controller
@RequestMapping("/")
public class OrderTypeController {

    private static final Logger logger = Logger.getLogger(OrderTypeController.class);

    public OrderTypeController() {
        System.out.println("OrderTypeController()");
    }

    @Autowired
    private OrderTypeService orderTypeService;

    /**
     * Извлечение всех типов приказов из таблицы
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = {"getAllOrderTypes", "/"})
    public ModelAndView getAllOrderTypes(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all OrderTypes.");
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        return new ModelAndView("orderTypeList", "orderTypeList", orderTypeList);
    }

    /**
     * Создание типа приказа
     * @param orderType
     * @return
     */
    @RequestMapping("createOrderType")
    public ModelAndView createOrderType(@ModelAttribute OrderType orderType) {
        logger.info("Creating OrderType. Data: " + orderType);
        return new ModelAndView("orderTypeForm");
    }

    /**
     * Редактирование типа приказа
     * @param id
     * @param orderType
     * @return
     */
    @RequestMapping("editOrderType")
    public ModelAndView editOrderType(@RequestParam long id,@ModelAttribute OrderType orderType){
        logger.info("Update the OrderType for the Id" + id);
        orderType = orderTypeService.getOrderType(id);
        return new ModelAndView("orderTypeForm","orderTypeObject",orderType);
    }

    /**
     * Сохранение типа приказа
     * @param orderType
     * @return
     */
    @RequestMapping("saveOrderType")
    public ModelAndView saveOrderType(@ModelAttribute OrderType orderType){
        logger.info("Saving the OrderType. Data: " + orderType);
        /**
         * Проверка редактировали тип приказа или создавали новый
         * Если orderType id 0, тогда создаем сотрудника, если нет, то обновляем существующего
         */
        if(orderType.getId() == 0) {
            orderTypeService.createOrderType(orderType);
        } else {
            orderTypeService.updateOrderType(orderType);
        }
        return new ModelAndView("redirect:getAllOrderTypes");
    }

    /**
     * Удаление типа приказа
     * @param id
     * @return
     */
    @RequestMapping("deleteOrderType")
    public ModelAndView deleteOrderType(@RequestParam long id) {
        logger.info("Deleting the OrderType. Id : "+id);
        orderTypeService.deleteOrderType(id);
        return new ModelAndView("redirect:getAllOrderTypes");
    }



}

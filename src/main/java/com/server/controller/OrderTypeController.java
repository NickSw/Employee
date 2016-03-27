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

@Controller
@RequestMapping("/")
public class OrderTypeController {
    private static final Logger logger = Logger.getLogger(OrderTypeController.class);

    public OrderTypeController() {
        System.out.println("OrderTypeController()");
    }

    @Autowired
    private OrderTypeService orderTypeService;

    @RequestMapping("createOrderType")
    public ModelAndView createOrderType(@ModelAttribute OrderType orderType) {
        logger.info("Creating OrderType. Data: " + orderType);
        return new ModelAndView("orderTypeForm");
    }

    @RequestMapping("editOrderType")
    public ModelAndView editOrderType(@RequestParam long id,@ModelAttribute OrderType orderType){
        logger.info("Update the OrderType for the Id" + id);
        orderType = orderTypeService.getOrderType(id);
        return new ModelAndView("orderTypeForm","orderTypeObject",orderType);
    }

    @RequestMapping("saveOrderType")
    public ModelAndView saveOrderType(@ModelAttribute OrderType orderType){
        logger.info("Saving the OrderType. Data: " + orderType);
        if(orderType.getId() == 0) {
            orderTypeService.createOrderType(orderType);
        } else {
            orderTypeService.updateOrderType(orderType);
        }
        return new ModelAndView("redirect:getAllOrderTypes");
    }

    @RequestMapping("deleteOrderType")
    public ModelAndView deleteOrderType(@RequestParam long id) {
        logger.info("Deleting the OrderType. Id : "+id);
        orderTypeService.deleteOrderType(id);
        return new ModelAndView("redirect:getAllOrderTypes");
    }

    @RequestMapping(value = {"getAllOrderTypes", "/"})
    public ModelAndView getAllOrderTypes(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all OrderTypes.");
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        return new ModelAndView("orderTypeList", "orderTypeList", orderTypeList);
    }

}

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

    @RequestMapping("editMovement")
    public ModelAndView editMovement(@RequestParam int id,@ModelAttribute Movement movement){
        logger.info("Update the Movement for the Id" + id);
        movement = movementService.getMovement(id);
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("movement", movement);
        model.put("employeeList", employeeList);
        model.put("orderTypeList",orderTypeList);
        return new ModelAndView("movementForm", "model", model);
    }

    @RequestMapping("saveMovement")
    public ModelAndView saveMovement(@ModelAttribute Movement movement){
        logger.info("Saving the Movement. Data: " + movement);
        if(movement.getId() == 0) {
            movementService.createMovement(movement);
        } else {
          movementService.updateMovement(movement);
        }
        return new ModelAndView("redirect:getAllMovements");
    }

    @RequestMapping("deleteMovement")
    public ModelAndView deleteMovement(@RequestParam int id) {
        logger.info("Deleting the Movement. Id : "+id);
        movementService.deleteMovement(id);
        return new ModelAndView("redirect:getAllMovements");
    }

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

    @RequestMapping("archiveMovement")
    public ModelAndView archiveMovement(@RequestParam int id) {
        logger.info("Archiving the Movement. Id : " + id);
        movementService.moveToMovementArchive(id);
        return new ModelAndView("redirect:getAllMovementsArchive");
    }

    @RequestMapping("copyMovement")
    public ModelAndView copyMovement(@RequestParam int id) {
        logger.info("Copying the Movement. Id : " + id);
        movementService.copyMovement(id);
        return new ModelAndView("redirect:getAllMovements");
    }
}

package com.server.controller;
import com.server.entity.Movement;
import com.server.service.MovementService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MovementController {
    private static final Logger logger = Logger.getLogger(MovementController.class);

    public MovementController() {
        System.out.println("MovementController()");
    }

    @Autowired
    private MovementService movementService;

    @RequestMapping("createMovement")
    public ModelAndView createMovement(@ModelAttribute Movement movement) {
        logger.info("Creating Movement. Data: " + movement);
        return new ModelAndView("movementForm");
    }

    @RequestMapping("editMovement")
    public ModelAndView editMovement(@RequestParam int id,@ModelAttribute Movement movement){
        logger.info("Update the Movement for the Id" + id);
        movement = movementService.getMovement(id);
        return new ModelAndView("movementForm","movementObject",movement);
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
    public ModelAndView getAllMovements() {
        logger.info("Getting the all Movements.");
        List<Movement> movementList = movementService.getAllMovements();
        return new ModelAndView("movementList", "movementList", movementList);
    }

    @RequestMapping("archiveMovement")
    public ModelAndView archiveMovement(@RequestParam int id) {
        logger.info("Archiving the Movement. Id : " + id);
        movementService.moveToMovementArchive(id);
        return new ModelAndView("redirect:getAllMovementsArchive");
    }
}

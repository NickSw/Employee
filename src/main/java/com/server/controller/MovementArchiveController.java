package com.server.controller;
import com.server.entity.MovementArchive;
import com.server.service.MovementArchiveService;
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
public class MovementArchiveController {
    private static final Logger logger = Logger.getLogger(MovementArchiveController.class);

    public MovementArchiveController() {
        System.out.println("MovementArchiveController()");
    }

    @Autowired
    private MovementArchiveService movementArchiveService;

    @RequestMapping("createMovementArchive")
    public ModelAndView createMovementArchive(@ModelAttribute MovementArchive movementArchive) {
        logger.info("Creating MovementArchive. Data: " + movementArchive);
        return new ModelAndView("movementArchiveForm");
    }

    @RequestMapping("editMovementArchive")
    public ModelAndView editMovementArchive(@RequestParam int id,@ModelAttribute MovementArchive movementArchive){
        logger.info("Update the MovementArchive for the Id" + id);
        movementArchive = movementArchiveService.getMovementArchive(id);
        return new ModelAndView("movementArchiveForm","movementArchiveObject",movementArchive);
    }

    @RequestMapping("saveMovementArchive")
    public ModelAndView saveMovementArchive(@ModelAttribute MovementArchive movementArchive){
        logger.info("Saving the MovementArchive. Data: " + movementArchive);
        if(movementArchive.getId() == 0) {
            movementArchiveService.createMovementArchive(movementArchive);
        } else {
            movementArchiveService.updateMovementArchive(movementArchive);
        }
        return new ModelAndView("redirect:getAllMovementsArchive");
    }

    @RequestMapping("deleteMovementArchive")
    public ModelAndView deleteMovementArchive(@RequestParam int id) {
        logger.info("Deleting the MovementArchive. Id : "+id);
        movementArchiveService.deleteMovementArchive(id);
        return new ModelAndView("redirect:getAllMovementsArchive");
    }

    @RequestMapping(value = {"getAllMovementsArchive", "/"})
    public ModelAndView getAllMovementsArchive() {
        logger.info("Getting the all MovementsArchive.");
        List<MovementArchive> movementArchiveList = movementArchiveService.getAllMovementsArchive();
        return new ModelAndView("movementArchiveList", "movementArchiveList", movementArchiveList);
    }

}

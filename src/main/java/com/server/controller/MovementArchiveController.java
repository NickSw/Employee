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
 * ���������� ��� ������� ����� �������� �� �����������
 * ������:
 * ���������� ���� �������� �������� �� ����������� �� ������� � ��������� �� ��������
 * �������� ��������� �������
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
     * ���������� ���� �������� ����� �������� �� �������
     * ���������� ����� �������� ��� �������
     * @param fileBean
     * @param result
     * @return
     */
    @RequestMapping(value = {"getAllMovementsArchive", "/"})
    public ModelAndView getAllMovementsArchive(@ModelAttribute("fileBean") FileBean fileBean, BindingResult result) {
        logger.info("Getting the all MovementsArchive.");
        /**���������� ���������*/
        List<MovementArchive> movementArchiveList = movementArchiveService.getAllMovementsArchive();
        List<OrderType> orderTypeList = orderTypeService.getAllOrderTypes();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("movementArchiveList",movementArchiveList);
        model.put("orderTypeList",orderTypeList);
        return new ModelAndView("movementArchiveList", "model", model);
    }

    /**
     * �������� ��������� ������� �� �������
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

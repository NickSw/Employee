package com.server.service.impl;

import com.server.dao.MovementDAO;
import com.server.entity.Movement;
import com.server.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MovementServiceImpl implements MovementService{

    public MovementServiceImpl(){
        System.out.println("MovementServiceImpl");
    }

    @Autowired
    private MovementDAO movementDAO;

    @Override
    public long createMovement(Movement movement) {
        return movementDAO.createMovement(movement);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        return movementDAO.updateMovement(movement);
    }

    @Override
    public void deleteMovement(int id) {
        movementDAO.deleteMovement(id);
    }

    @Override
    public List<Movement> getAllMovements() {
        return movementDAO.getAllMovements();
    }

    @Override
    public Movement getMovement(int id) {
        return movementDAO.getMovement(id);
    }

    @Override
    public List<Movement> getAllMovements(String orderNumber) {
        return movementDAO.getAllMovements(orderNumber);
    }
}

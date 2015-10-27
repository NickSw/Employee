package com.server.service;
import com.server.entity.Movement;

import java.util.List;

public interface MovementService {
    public long createMovement(Movement movement);
    public Movement updateMovement(Movement movement);
    public void deleteMovement(int id);
    public List<Movement> getAllMovements();
    public Movement getMovement(int id);
    public List<Movement> getAllMovements(String orderNumber);
}

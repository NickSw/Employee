package com.server.dao;


import com.server.entity.Movement;

import java.util.List;

public interface MovementDAO {
    public long createMovement(Movement movement);
    public Movement updateMovement(Movement movement);
    public void deleteMovement(long id);
    public List<Movement> getAllMovements();
    public Movement getMovement(long id);
    public void moveToMovementArchive(long id);
}

package com.server.dao;


import com.server.entity.MovementArchive;

import java.util.List;

public interface MovementArchiveDAO {
    public long createMovementArchive(MovementArchive movementArchive);
    public MovementArchive updateMovementArchive(MovementArchive movementArchive);
    public void deleteMovementArchive(long id);
    public List<MovementArchive> getAllMovementsArchive();
    public MovementArchive getMovementArchive(long id);
}

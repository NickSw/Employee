package com.server.service;
import com.server.entity.MovementArchive;

import java.util.List;

public interface MovementArchiveService {
    public long createMovementArchive(MovementArchive movementArchive);
    public MovementArchive updateMovementArchive(MovementArchive movementArchive);
    public void deleteMovementArchive(int id);
    public List<MovementArchive> getAllMovementsArchive();
    public MovementArchive getMovementArchive(int id);
}

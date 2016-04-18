package com.server.service;
import com.server.entity.MovementArchive;

import java.util.List;

public interface MovementArchiveService {
    public List<MovementArchive> getAllMovementsArchive();
    public void deleteMovementArchive(int id);
}

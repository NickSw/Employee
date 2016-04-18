package com.server.dao;


import com.server.entity.MovementArchive;

import java.util.List;

public interface MovementArchiveDAO {
    public List<MovementArchive> getAllMovementsArchive();
    public void deleteMovementArchive(long id);
}

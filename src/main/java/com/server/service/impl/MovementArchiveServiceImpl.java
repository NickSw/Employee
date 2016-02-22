package com.server.service.impl;

import com.server.dao.MovementArchiveDAO;
import com.server.entity.MovementArchive;
import com.server.service.MovementArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MovementArchiveServiceImpl implements MovementArchiveService{

    public MovementArchiveServiceImpl(){
        System.out.println("MovementArchiveServiceImpl");
    }

    @Autowired
    private MovementArchiveDAO movementArchiveDAO;

    @Override
    public long createMovementArchive(MovementArchive movementArchive) {
        return movementArchiveDAO.createMovementArchive(movementArchive);
    }

    @Override
    public MovementArchive updateMovementArchive(MovementArchive movementArchive) {
        return movementArchiveDAO.updateMovementArchive(movementArchive);
    }

    @Override
    public void deleteMovementArchive(int id) {
        movementArchiveDAO.deleteMovementArchive(id);
    }

    @Override
    public List<MovementArchive> getAllMovementsArchive() {
        return movementArchiveDAO.getAllMovementsArchive();
    }

    @Override
    public MovementArchive getMovementArchive(int id) {
        return movementArchiveDAO.getMovementArchive(id);
    }

}

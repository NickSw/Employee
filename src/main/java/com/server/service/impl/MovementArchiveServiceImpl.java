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
    public List<MovementArchive> getAllMovementsArchive() {
        return movementArchiveDAO.getAllMovementsArchive();
    }

    @Override
    public void deleteMovementArchive(int id) {
        movementArchiveDAO.deleteMovementArchive(id);
    }

}

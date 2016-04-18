package com.server.service.impl;

import com.server.dao.MovementArchiveDAO;
import com.server.entity.MovementArchive;
import com.server.service.MovementArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса MovementArchiveService
 * Методы:
 * Извлечь всех архивных приказов по сотрудникам из архива приказов по сотрудникам
 * Удалить архивный приказ по сотруднику из архива приказов по сотрудникам
 *
 * Осуществляется при помощи слоя DAO
 */@Service
@Transactional
public class MovementArchiveServiceImpl implements MovementArchiveService{

    public MovementArchiveServiceImpl(){
        System.out.println("MovementArchiveServiceImpl");
    }

    @Autowired
    private MovementArchiveDAO movementArchiveDAO;

    /**
     * Извлечь все архивные приказы по сотрудникам
     * @return
     */
    @Override
    public List<MovementArchive> getAllMovementsArchive() {
        return movementArchiveDAO.getAllMovementsArchive();
    }

    /**
     * Удалить архивный приказ
     * @param id
     */
    @Override
    public void deleteMovementArchive(int id) {
        movementArchiveDAO.deleteMovementArchive(id);
    }

}
